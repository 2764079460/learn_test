package com.markerhub.shiro;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by xiangmiao on 2020/6/12.
 */
@Data
public class AccountProfile implements Serializable{
    private Long id;

    private String username;

    private String avatar;

    private String email;
}
