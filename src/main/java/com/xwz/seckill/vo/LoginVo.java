package com.xwz.seckill.vo;

import com.xwz.seckill.validator.IsMobile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    @NotBlank(message = "必须有手机号")
    @IsMobile
    private String mobile;
    @NotBlank(message = "必须填写密码")
    private String password;
}
