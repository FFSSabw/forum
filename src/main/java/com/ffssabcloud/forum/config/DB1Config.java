package com.ffssabcloud.forum.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = DB1Config.PACKAGE, sqlSessionFactoryRef = "DB1SqlSessionFactory")
public class DB1Config {
    
    @Autowired
    private Environment env;
    
    static final String PACKAGE = "com.ffssabcloud.forum.domain.DB1";
    static final String MAPPER_LOCATION = "classpath*:mapper/DB1/*.xml";
    
    @Bean(name = "DB1DataSource")
    @Primary
    public DataSource dBDataSource() {
        
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("db1.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("db1.datasource.url"));
        dataSource.setUsername(env.getProperty("db1.datasource.username"));
        dataSource.setPassword(env.getProperty("db1.datasource.password"));
        
        return dataSource;
    }
    
    @Bean(name = "DB1TransactionManager")
    @Primary
    public DataSourceTransactionManager dBTransactionManager() {
        return new DataSourceTransactionManager(dBDataSource());
    }
    
    @Bean(name = "DB1SqlSessionFactory")
    @Primary
    public SqlSessionFactory dBSqlSessionFactory(@Qualifier("DB1DataSource") DataSource dB1DataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dB1DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DB1Config.MAPPER_LOCATION));
        
        return sessionFactory.getObject();
    }
}
