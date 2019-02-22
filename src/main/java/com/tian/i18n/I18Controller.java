/*
package com.tian.i18n;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;

import static com.sun.webpane.platform.ConfigManager.log;

@Controller
public class I18Controller {
    private static final Logger LOGGER = (Logger) LoggerFactory
            .getLogger(I18Controller.class);

    private MessageSource messageSource;

    @Value("${spring.messages.basename}")
    private String basename;

    @Value("${spring.messages.cache-seconds}")
    private long cacheMillis;//缓存信息

    @Value("${spring.messages.encoding}")
    private String encoding;//编码


    */
/**
     * 初始化
     * @return
     *//*

    private MessageSource initMessageSource(){
        //Spring的MessageSource有两个常用的实现ReloadableResourceBundleMessageSource和ResourceBundleMessageSource
        //ReloadableResourceBundleMessageSource是对MessageSource的一种实现
        //ReloadableResourceBundleMessageSource内部是使用PropertiesPersister来加载对应的文件，
        //这包括properties文件和xml文件，然后使用java.util.Properties来保存对应的数据。
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        log.info("baseName==========>:" + this.basename);
        messageSource.setBasename(basename);
        messageSource.setDefaultEncoding(encoding);
        messageSource.setCacheMillis(cacheMillis);
        return messageSource;
    }

    private String getMessage(HttpServletRequest request,String code){
        if (messageSource == null){
            messageSource = initMessageSource();
        }

        String lauage = request.getHeader("Accept-Language");
        //默认没有 即为当前请求地区语言
        Locale locale = null;
        if (lauage == null){
            locale = request.getLocale();
        }else if ("en-US".equals(lauage)){
            locale = Locale.ENGLISH;
        }else if ("zh-CN".equals(lauage)){
            locale = Locale.SIMPLIFIED_CHINESE;
        }

        //其余不正确的默认就是本地的语言
        else{
            locale=request.getLocale();
        }

        String result = null;
        try {
            result = messageSource.getMessage(code, null, locale);
        } catch (NoSuchMessageException e) {
            LOGGER.error("Cannot find the error message of internationalization, return the original error message.");
        }

        if (result == null){
            return code;
        }
        return result;
    }







}
*/
