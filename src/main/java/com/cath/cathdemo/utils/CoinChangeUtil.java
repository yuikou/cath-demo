package com.cath.cathdemo.utils;

import com.cath.cathdemo.bean.Bpi;
import com.cath.cathdemo.bean.MyCoin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CoinChangeUtil implements ApplicationContextAware, EmbeddedValueResolverAware {

    @Autowired
    static ApplicationContext applicationContext;

    @Autowired
    static StringValueResolver stringValueResolver;

    public static String parseUpdateTime(String updated) throws ParseException {
//        "updated": "Sep 26, 2022 03:51:00 UTC",
//        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss", Locale.US);
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date parse = sdf.parse(updated.substring(0,updated.indexOf("UTC")-1));
//        String s = sf.format(parse);

        LocalDateTime dateTime = LocalDateTime.parse(updated, DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss 'UTC'", Locale.US));
        String s = dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return s;
    }

    public static List<MyCoin> getDetails(Map<String, Bpi> bpiMap) {
        return bpiMap.keySet().stream().map(
                k -> new MyCoin(bpiMap.get(k).getCode(), getTwCurName(bpiMap.get(k).getCode()), bpiMap.get(k).getRate_float())
        ).collect(Collectors.toList());

    }

    static String getTwCurName(String coinname){
        String twname = "";

        try{
            twname = stringValueResolver.resolveStringValue("${cath.bpi.tw."+ coinname +"}");
        } catch (IllegalArgumentException e){
            log.error("cath.bpi.tw裡面沒有對應的中文幣別, 英文代號{}", coinname);
        }
        return twname;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CoinChangeUtil.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}
