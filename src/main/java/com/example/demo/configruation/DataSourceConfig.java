package com.example.demo.configruation;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource")
	DataSource ds() {
		return  DruidDataSourceBuilder.create().build();
	}
}
