package com.sdstc.advice;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.io.InputStream;

@RestControllerAdvice
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {
    private static String key="chengisgentorman";

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter parameter, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (parameter.getMethod().isAnnotationPresent(SecretAnnotation.class)){
            SecretAnnotation secretAnnotation= parameter.getMethodAnnotation(SecretAnnotation.class);
            if(secretAnnotation.encode()){
                ObjectMapper objectMapper = new ObjectMapper();
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                SM4 sm4 = (SM4) SmUtil.sm4(key.getBytes());
                return sm4.encrypt(result);
            }
        }
        return body;
    }
}
