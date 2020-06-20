package com.markerhub.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by xiangmiao on 2020/6/17.
 */
@Data
public class LoginDto implements Serializable {

    private static final long serialVersionUID = -1214478819207875454L;

    @NotBlank(message = "昵称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
