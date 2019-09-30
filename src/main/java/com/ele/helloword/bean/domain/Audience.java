package com.ele.helloword.bean.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @name: Audience
 * @description:
 * @author: xiangyf
 * @create: 2019-08-19 21:44
 */
@ConfigurationProperties(prefix = "audience")
@Component
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}
