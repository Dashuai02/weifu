package com.weifu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class School implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String money;

}
