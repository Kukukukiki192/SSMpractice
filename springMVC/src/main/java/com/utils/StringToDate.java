package com.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换成日期
 */
public class StringToDate implements Converter<String, Date> {
    /**
     *
     * @param s 传入字符串
     * @return
     */
    @Override
    public Date convert(String s) {
        if(s==null) {
            throw new RuntimeException("请填写日期!");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(s);    //字符串转换成日期
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出错");
        }
    }
}
