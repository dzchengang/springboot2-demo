package com.sdstc.advice;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@RestControllerAdvice
public class DecodeRequestBodyAdvice implements RequestBodyAdvice {
    private static String key="chengisgentorman";
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        if (parameter.getMethod().isAnnotationPresent(SecretAnnotation.class)){
            SecretAnnotation secretAnnotation= parameter.getMethodAnnotation(SecretAnnotation.class);
            if(secretAnnotation.decode()){
                return new HttpInputMessage() {
                    @Override
                    public InputStream getBody() throws IOException {
                        String encodeBody = IOUtils.toString(inputMessage.getBody(),"utf-8");
                        SM4 sm4 = (SM4) SmUtil.sm4(key.getBytes());
                        return IOUtils.toInputStream(sm4.decryptStr(encodeBody),"utf-8");
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        return inputMessage.getHeaders();
                    }
                };
            }
        }
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        return body;
    }
}
