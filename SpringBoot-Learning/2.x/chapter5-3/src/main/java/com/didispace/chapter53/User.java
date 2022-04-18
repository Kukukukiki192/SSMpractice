package com.didispace.chapter53;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//为需要同步的缓存对象实现Serializable接口
//注意：如果没有做这一步，后续缓存集群通过过程中，因为要传输User对象，会导致序列化与反序列化相关的异常
@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
