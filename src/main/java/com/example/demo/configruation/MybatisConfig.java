package com.example.demo.configruation;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.example.demo.Dao",sqlSessionFactoryRef = "sqlSessionFactoryBean")
public class MybatisConfig {

	@Autowired
	@Qualifier("ds")
	DataSource ds;
	@Bean
	SqlSessionFactory sqlSessionFactoryBean() throws Exception
	{
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		return factoryBean.getObject();
	}
}
