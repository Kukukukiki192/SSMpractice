package com.hehe.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局日期格式化
 *
 * 使用注解@JsonComponent 可以:
 * 1、快速自定义日期格式化的序列化器，免除传统通过模块注册的烦恼。
 * 2、实现与当地无关的动态时区的精髓就在于将获取当前等人的方法写在解析日期和格式化日期的代码里。
 * 3、是直接处理String和Date的相互转换的，所以要注意空串问题。例如dateFormat.parse()要预防空串。
 */
@JsonComponent //使用之后就不需要手动将Jackson的序列化和反序列化手动加入ObjectMapper
public class DateFormatConfig {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //在同一个类中定义两个内部类来实现序列化和反序列化

    /**
     * 日期格式化 序列化 Java对象->字节序列
     */
    public static class DateJsonSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(dateFormat.format(date));
        }
    }

    /**
     * 解析日期字符串 反序列化 字节序列->Java对象
     */
    public static class DateJsonDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            try {
                return dateFormat.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
/**
 * 两个Java进程进行通信时, 通过Java序列化与反序列化实现进程间的对象传送:
 *  发送方把Java对象转换为字节序列，在网络上传送;接收方需要从字节序列中恢复出Java对象
 *
 * 好处:
 * 1.实现了数据的持久化
 * 2.利用序列化实现远程通信
 *
 * 总结:
 * （1）永久性保存对象，保存对象的字节序列到本地文件或者数据库中；
 * （2）通过序列化以字节流的形式使对象在网络中进行传递和接收；
 * （3）通过序列化在进程间传递对象；
 **/