package com.zr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * t_admin
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_admin")
public class Admin implements Serializable {

    @TableId
    private Long id;

    private String username;

    private String pwd;

    private String roles;

    private static final long serialVersionUID = 1L;


}