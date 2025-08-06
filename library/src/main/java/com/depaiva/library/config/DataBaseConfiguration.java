package com.depaiva.library.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {

    // declaração de atributos que armazenam informações do application.yml
    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;

    // implementação básica de um data Source, não recomendada em grande escala
    // @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(this.url);
        ds.setUsername(this.username);
        ds.setPassword(this.password);
        ds.setDriverClassName(this.driver);
        return ds;
    }


    @Bean
    public DataSource hikariDataSource() {
        // configurações básicas do data source
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        // configurações do pool de conexões
        config.setMaximumPoolSize(10); // tamanho máximo do pool de conexões
        config.setMinimumIdle(1); // minimo inicial do pool
        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); // conexão dura no maximo 600000ms (10 minutos)
        config.setConnectionTimeout(100000); // timeout para realizar a conexão
        config.setConnectionTestQuery("select 1"); // query para ver se o banco está funcinando

        return new HikariDataSource(config); // o hikari dataSource exige uma HikariConfig antes de ser instanciada
    }
}
