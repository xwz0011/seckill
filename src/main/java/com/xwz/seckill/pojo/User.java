package com.xwz.seckill.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private static final long serializableUID = 1L;

    private Long id;

    private String nickname;

    private String password;

    private String slat;

    private String head;

    private Date registerDate;

    private Date lastLoginDate;

    private  Integer loginCount;
}
