package com.lyf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:jdbc.properties")
@Import({MyBatisConfig.class, JdbcConfig.class})
@ComponentScan("com.lyf.service")
@EnableTransactionManagement
public class SpringConfig {

}
