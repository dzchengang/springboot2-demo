package com.sdstc.ylpay.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.DemoBase;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKConstants;

@RestController
@RequestMapping("/")
public class PayController {

	public static String version = "5.1.0";
	public static String encoding = "UTF-8";
	public static String signMethod = "01";

	@GetMapping("/pay")
	public void pay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=" + DemoBase.encoding);

		// 前台页面传过来的
		String merId = "777290058110048";
		String txnAmt = "1";
		String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		Map<String, String> requestData = new HashMap<String, String>();

		/*** 银联全渠道系统，产品参数，除了encoding自行选择外其他不需修改 ***/
		requestData.put("version", DemoBase.version); // 版本号，全渠道默认值
		requestData.put("encoding", DemoBase.encoding); // 字符集编码，可以使用UTF-8,GBK两种方式
		requestData.put("signMethod", SDKConfig.getConfig().getSignMethod()); // 签名方法
		requestData.put("txnType", "01"); // 交易类型 ，01：消费
		requestData.put("txnSubType", "01"); // 交易子类型， 01：自助消费
		requestData.put("bizType", "000201"); // 业务类型，B2C网关支付，手机wap支付
		requestData.put("channelType", "07"); // 渠道类型，这个字段区分B2C网关支付和手机wap支付；07：PC,平板 08：手机

		/*** 商户接入参数 ***/
		requestData.put("merId", merId); // 商户号码，请改成自己申请的正式商户号或者open上注册得来的777测试商户号
		requestData.put("accessType", "0"); // 接入类型，0：直连商户
		requestData.put("orderId", orderId); // 商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
		requestData.put("txnTime", txnTime); // 订单发送时间，取系统时间，格式为yyyyMMddHHmmss，必须取当前时间，否则会报txnTime无效
		requestData.put("currencyCode", "156"); // 交易币种（境内商户一般是156 人民币）
		requestData.put("txnAmt", txnAmt); // 交易金额，单位分，不要带小数点
		// requestData.put("reqReserved", "透传字段");
		// //请求方保留域，如需使用请启用即可；透传字段（可以实现商户自定义参数的追踪）本交易的后台通知,对本交易的交易状态查询交易、对账文件中均会原样返回，商户可以按需上传，长度为1-1024个字节。出现&={}[]符号时可能导致查询接口应答报文解析失败，建议尽量只传字母数字并使用|分割，或者可以最外层做一次base64编码(base64编码之后出现的等号不会导致解析失败可以不用管)。

		requestData.put("riskRateInfo", "{commodityName=测试商品名称}");

		requestData.put("frontUrl", "http://localhost:8089/ACPSample_B2C/frontRcvResponse");

		requestData.put("backUrl", "http://222.222.222.222:8089/ACPSample_B2C/backRcvResponse");

		requestData.put("payTimeout", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime() + 15 * 60 * 1000));

		/** 请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面 **/
		Map<String, String> submitFromData = AcpService.sign(requestData, DemoBase.encoding); // 报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。

		String requestFrontUrl = SDKConfig.getConfig().getFrontRequestUrl(); // 获取请求银联的前台地址：对应属性文件acp_sdk.properties文件中的acpsdk.frontTransUrl
		String html = AcpService.createAutoFormHtml(requestFrontUrl, submitFromData, DemoBase.encoding); // 生成自动跳转的Html表单

		LogUtil.writeLog("打印请求HTML，此为请求报文，为联调排查问题的依据：" + html);
		resp.getWriter().write(html);
	}

	@GetMapping("/front")
	public void front(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LogUtil.writeLog("FrontRcvResponse前台接收报文返回开始");

		String encoding = req.getParameter(SDKConstants.param_encoding);
		LogUtil.writeLog("返回报文中encoding=[" + encoding + "]");
		String pageResult = "";
		if (DemoBase.encoding.equalsIgnoreCase(encoding)) {
			pageResult = "/utf8_result.jsp";
		} else {
			pageResult = "/gbk_result.jsp";
		}
		Map<String, String> respParam = getAllRequestParam(req);

		// 打印请求报文
		LogUtil.printRequestLog(respParam);

		Map<String, String> valideData = null;
		StringBuffer page = new StringBuffer();
		if (null != respParam && !respParam.isEmpty()) {
			Iterator<Entry<String, String>> it = respParam.entrySet().iterator();
			valideData = new HashMap<String, String>(respParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes(encoding), encoding);
				page.append("<tr><td width=\"30%\" align=\"right\">" + key + "(" + key + ")</td><td>" + value + "</td></tr>");
				valideData.put(key, value);
			}
		}
		if (!AcpService.validate(valideData, encoding)) {
			page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>失败</td></tr>");
			LogUtil.writeLog("验证签名结果[失败].");
		} else {
			page.append("<tr><td width=\"30%\" align=\"right\">验证签名结果</td><td>成功</td></tr>");
			LogUtil.writeLog("验证签名结果[成功].");
			System.out.println(valideData.get("orderId")); // 其他字段也可用类似方式获取

			String respCode = valideData.get("respCode");
			// 判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。
		}
		req.setAttribute("result", page.toString());
		req.getRequestDispatcher(pageResult).forward(req, resp);

		LogUtil.writeLog("FrontRcvResponse前台接收报文返回结束");
	}

	@GetMapping("/back")
	public void back(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		LogUtil.writeLog("BackRcvResponse接收后台通知开始");

		String encoding = req.getParameter(SDKConstants.param_encoding);
		// 获取银联通知服务器发送的后台通知参数
		Map<String, String> reqParam = getAllRequestParam(req);
		LogUtil.printRequestLog(reqParam);

		// 重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
		if (!AcpService.validate(reqParam, encoding)) {
			LogUtil.writeLog("验证签名结果[失败].");
			// 验签失败，需解决验签问题

		} else {
			LogUtil.writeLog("验证签名结果[成功].");
			// 【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态

			String orderId = reqParam.get("orderId"); // 获取后台通知的数据，其他字段也可用类似方式获取
			String respCode = reqParam.get("respCode");
			// 判断respCode=00、A6后，对涉及资金类的交易，请再发起查询接口查询，确定交易成功后更新数据库。

		}
		LogUtil.writeLog("BackRcvResponse接收后台通知结束");
		// 返回给银联服务器http 200 状态码
		resp.getWriter().print("ok");
	}

	public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (res.get(en) == null || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}
}
