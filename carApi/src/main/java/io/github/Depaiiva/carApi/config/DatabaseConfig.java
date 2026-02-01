package io.github.Depaiiva.carApi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

  @Value("${spring.datasource.url}")
  String url;

  @Value("${spring.datasource.username}")
  String username;

  @Value("${spring.datasource.password}")
  String password;

  @Value("${spring.datasource.driver-class-name}")
  String driver;

  // Obsoleto
  // @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setUrl(url);
    ds.setDriverClassName(driver);
    ds.setUsername(username);
    ds.setPassword(password);

    return ds;
  }

  @Bean
  public DataSource hikariDataSource() {
    // config basica de uma conexão com o banco
    HikariConfig config = new HikariConfig();
    config.setUsername(username);
    config.setPassword(password);
    config.setDriverClassName(driver);
    config.setJdbcUrl(url);

    // config basica de um pool de conexões
    config.setPoolName("car-pool"); // nome do pool
    config.setMaximumPoolSize(10); // maximo de conexões liberadas
    config.setMinimumIdle(1); // tamanho inicial do pool
    config.setMaxLifetime(600000); // tempo de conexão com o banco 600 mil ms = 10 minutos
    config.setConnectionTimeout(100000); // timeout para realizar uma conexão
    config.setConnectionTestQuery("select 1"); // query para testar a conexão com o banco

    return new HikariDataSource(config);
  }
}
