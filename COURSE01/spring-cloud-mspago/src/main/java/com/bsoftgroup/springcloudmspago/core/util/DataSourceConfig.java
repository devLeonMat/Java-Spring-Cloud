package com.bsoftgroup.springcloudmspago.core.util;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		ResponseEntity<DatosConexion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8084/mproperties/datosconexion", DatosConexion.class);
		DatosConexion response = responseEntity.getBody();
		dataSource.setDriverClassName(response.getDriverclassname());
		dataSource.setUrl(response.getUrl());
		dataSource.setUsername(response.getUsername());
		dataSource.setPassword(response.getPassword());
		return dataSource;
	}
}