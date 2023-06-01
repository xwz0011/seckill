package com.xwz.seckill.mapper;

import com.xwz.seckill.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserMapper {
    User queryById(String id);
}
