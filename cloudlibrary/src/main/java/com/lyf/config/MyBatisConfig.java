package com.lyf.config;


import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

public class MyBatisConfig {

    @Bean
    public PageInterceptor getPageInterceptor(){
        return new PageInterceptor();
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource, PageInterceptor pageInterceptor){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.lyf.domain");

        Interceptor[] plugins = {pageInterceptor};
        sqlSessionFactoryBean.setPlugins(plugins);

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.lyf.dao");
        return mapperScannerConfigurer;
    }

}
