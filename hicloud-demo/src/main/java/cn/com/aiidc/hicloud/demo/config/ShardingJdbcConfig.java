package cn.com.aiidc.hicloud.demo.config;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;


@Configuration
public class ShardingJdbcConfig {
	
	@Bean("dataSource")
	public DataSource hikariDataSource() throws IOException, SQLException {
		DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(ResourceUtils.getFile("classpath:sharding-jdbc.yml"));
		return dataSource;
	}
	
}
