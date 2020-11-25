package com.sdstc.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("httpClientService")
public class HttpClientService {
    @Autowired
    private HttpClient httpClient;

    /**
     * 认证
     *
     * @param hostUrl
     * @param tenantUid
     * @param authCode
     */
    public void auth(String hostUrl, String tenantUid, String authCode) {
        try {
            HttpGet httpget = new HttpGet(hostUrl + "/Admin/rest/authentication-point/authenticate?tenant=" + tenantUid);// 创建一个Get请求对象
            httpget.addHeader("Authorization", authCode);
            HttpResponse response = httpClient.execute(httpget);
            String result = EntityUtils.toString(response.getEntity(), "gb2312");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增主机
     * @param hostUrl
     * @param hostEntity
     */
    public void createHost(String hostUrl, String hostEntity) {
        try {
            HttpPost httppost = new HttpPost(hostUrl + "/Admin/rest/v1/hosts");
            httppost.setHeader("Content-Type", "application/xml");
            httppost.setHeader("Accept", "application/xml");

            StringEntity entityParams = new StringEntity(hostEntity, ContentType.APPLICATION_ATOM_XML);
            httppost.setEntity(entityParams);

            HttpResponse response = httpClient.execute(httppost);
            String result = EntityUtils.toString(response.getEntity(),"gb2312");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
