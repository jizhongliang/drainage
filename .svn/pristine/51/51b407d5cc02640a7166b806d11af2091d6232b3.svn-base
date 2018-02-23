package com.py.merchant.config;

/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 * @author Administrator
 * @version $Id: DruidConfig.java, v 0.1 2017年11月26日 下午12:33:47 Administrator Exp $
 */
@Configuration
public class DruidConfig {

    private Logger  logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${spring.datasource.url}")
    private String  dbUrl;

    @Value("${spring.datasource.username}")
    private String  username;

    @Value("${spring.datasource.password}")
    private String  password;

    @Value("${spring.datasource.driver-class-name}")
    private String  driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int     initialSize;

    @Value("${spring.datasource.minIdle}")
    private int     minIdle;

    @Value("${spring.datasource.maxActive}")
    private int     maxActive;

    @Value("${spring.datasource.maxWait}")
    private int     maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int     timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int     minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String  validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.filters}")
    private String  filters;

    @Value("${spring.datasource.logSlowSql}")
    private String  logSlowSql;

    @Value("${druid.login.name}")
    private String  loginName;

    @Value("${druid.login.password}")
    private String  loginPassword;

    @Bean
    public ServletRegistrationBean druidServlet() {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", loginName);
        reg.addInitParameter("loginPassword", loginPassword);
        reg.addInitParameter("logSlowSql", logSlowSql);
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        reg.addInitParameter("resetEnable", "false");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",
            "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

}
