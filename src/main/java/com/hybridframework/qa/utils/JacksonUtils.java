package com.hybridframework.qa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jyoti on 14/04/2020
 */

public class JacksonUtils {

    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);
    }
}
