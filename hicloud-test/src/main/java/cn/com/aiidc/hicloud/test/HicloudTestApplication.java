package cn.com.aiidc.hicloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"cn.com.aiidc.hicloud"})
@EnableDiscoveryClient
@EnableFeignClients
public class HicloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HicloudTestApplication.class, args);
	}

}

