package com.xwz.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum RespBeanEnum {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),

    ERROR_LOGIN(598, "账号或密码错误"),
    ERROR_BIND(597,"参数验证错误"),

    SECKILL_STOCK_ERROR(589,"商品库存不足！"),
    SECKILL_DOUBLE_BUY(588,"此商品每位用户限购一件");
    private final Integer code;
    private final String message;
}
