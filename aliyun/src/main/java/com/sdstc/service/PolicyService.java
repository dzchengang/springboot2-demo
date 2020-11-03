package com.sdstc.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.sdstc.dto.PolicyDto;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service("testService")
public class PolicyService {
    public PolicyDto test() throws UnsupportedEncodingException {
        String endpoint="";
        String accessId="";
        String accessKey="";
        String ossProtocol="http";
        String bucket="test-chengang";
        String dir="test/";

        OSS client =new OSSClientBuilder().build(endpoint, accessId, accessKey);

        String host = ossProtocol+"://" + bucket + "." + endpoint;

        //过期时间 秒
        long expireTime = 100;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        //代理
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 3000000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        //生成policy
        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("UTF-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        //计算戳
        String postSignature = client.calculatePostSignature(postPolicy);

        PolicyDto policyDto=new PolicyDto();
        policyDto.setAccessid(accessId);
        policyDto.setPolicy(encodedPolicy);
        policyDto.setSignature(postSignature);
        policyDto.setDir(dir);
        policyDto.setHost(host);
        policyDto.setExpire(String.valueOf(expireEndTime / 1000));


        client.shutdown();
        return policyDto;
    }
}
