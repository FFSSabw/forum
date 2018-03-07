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
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = DB2Config.PACKAGE, sqlSessionFactoryRef = "DB2SqlSessionFactory")
public class DB2Config {
    
    @Autowired
    private Environment env;
    
    static final String PACKAGE = "com.ffssabcloud.forum.domain.DB2";
    static final String MAPPER_LOCATION = "classpath*:mapper/DB2/*.xml";
    
    @Bean(name = "DB2DataSource")
    public DataSource dBDataSource() {
    
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("db2.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("db2.datasource.url"));
        dataSource.setUsername(env.getProperty("db2.datasource.username"));
        dataSource.setPassword(env.getProperty("db2.datasource.password"));
        
        return dataSource;
    }
    
    @Bean(name = "DB2TransactionManager")
    public DataSourceTransactionManager dBTransactionManager() {
        return new DataSourceTransactionManager(dBDataSource());
    }
    
    @Bean(name = "DB2SqlSessionFactory")
    public SqlSessionFactory dBSqlSessionFactory(@Qualifier("DB2DataSource") DataSource dB2DataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dB2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DB2Config.MAPPER_LOCATION));
        
        return sessionFactory.getObject();
    }
}
