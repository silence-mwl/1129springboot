package com.zr.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * t_user
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user") // 手动指定表名
public class User implements Serializable {

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除deleted
     */
    @TableLogic(value = "1",delval = "0")// 逻辑删除
    private Integer deleted = 1;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_ID) // 生成主键策略，默认使用雪花算法
    @JsonFormat(shape = JsonFormat.Shape.STRING) // json转换把long转成string
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private static final long serialVersionUID = 1L;
}