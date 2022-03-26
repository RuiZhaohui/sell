package com.zcc.mobile.sell.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhrui/芮照辉:zhrui@trip.com
 * @date 2022/3/26
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.zcc.mobile.sell.repository")
@EntityScan(basePackages = "com.zcc.mobile.sell.po")
@EnableJpaAuditing
public class SpringDataJpaConfiguration {
}
