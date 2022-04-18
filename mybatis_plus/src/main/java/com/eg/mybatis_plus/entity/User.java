package com.eg.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author K
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)    //chain为真,产生的setter返回的this(对象实例)而不是void
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @TableId(type = IdType.ASSIGN_ID) 默认-雪花算法
     * @TableId(type = IdType.AUTO) 主键自增 (影响所有实体-设置全局主键配置)
     */
    private Long id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;
}
