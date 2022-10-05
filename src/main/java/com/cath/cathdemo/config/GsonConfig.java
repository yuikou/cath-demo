//package com.cath.cathdemo.config;
//
//import com.google.gson.GsonBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Configuration
//public class GsonConfig {
//
//    @Value("${spring.gson.date-format}")
//    private String dateFormat;
//
//    public HttpMessageConverters converters() {
//        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//        gsonHttpMessageConverter.setGson(new GsonBuilder().setDateFormat(dateFormat).create());
//        messageConverters.add(gsonHttpMessageConverter);
//
//        return new HttpMessageConverters(true, messageConverters);
//    }
//}
