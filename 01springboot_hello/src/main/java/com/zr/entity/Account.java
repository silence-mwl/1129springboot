package com.zr.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * account
 * @author 
 */
@Data
@Builder
public class Account implements Serializable {
    private Integer id;

    private String name;

    private Integer balance;

    private static final long serialVersionUID = 1L;
}