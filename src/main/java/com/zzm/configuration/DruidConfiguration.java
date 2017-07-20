package com.zzm.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DruidConfiguration {

    @Value("${datasource.url}")
    private String dbUrl;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver-class-name}")
    private String driverClassName;
    @Value("${initialSize}")
    private int initialSize;
    @Value("${minIdle}")
    private int minIdle;
    @Value("${maxActive}")
    private int maxActive;
    @Value("${maxWait}")
    private int maxWait;
    @Value("${timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${validationQuery}")
    private String validationQuery;
    @Value("${testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${testOnReturn}")
    private boolean testOnReturn;
    @Value("${poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${filters}")
    private String filters;
    @Value("{connectionProperties}")
    private String connectionProperties;

    @Bean   //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
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
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource
                .setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter: " + e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }

    @Bean
    public ServletRegistrationBean statViewServle() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        // IP白名单
        //servletRegistrationBean.addInitParameter("allow", "192.168.1.218,127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        //servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的格式
        filterRegistrationBean
                .addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

