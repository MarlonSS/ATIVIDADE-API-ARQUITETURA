package br.com.testapi.springbootcommysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.testapi.springbootcommysql" )
@EntityScan(basePackages = "br.com.testapi.springbootcommysql.models")
public class SpringBootComMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootComMysqlApplication.class, args);
	}

}
