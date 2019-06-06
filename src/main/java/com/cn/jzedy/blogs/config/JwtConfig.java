package com.cn.jzedy.blogs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangyin
 * @date 2019/6/6
 */
@Data
@Component
@ConfigurationProperties(prefix ="jwt")
public class JwtConfig {
    private String header;

    private String bearer;

    private String secretKey;

    private String expiration;
}
