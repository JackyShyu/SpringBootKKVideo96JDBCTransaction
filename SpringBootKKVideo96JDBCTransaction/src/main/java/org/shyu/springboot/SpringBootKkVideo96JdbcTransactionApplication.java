package org.shyu.springboot;

import org.shyu.springboot.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootKkVideo96JdbcTransactionApplication implements CommandLineRunner{

	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringBootKkVideo96JdbcTransactionApplication.class, args);
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootKkVideo96JdbcTransactionApplication.class, args);
		
		String names[] =context.getBeanDefinitionNames();
		
		for (String beanName: names) {
			System.out.println(beanName);
		}
		
		
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {
		accountServiceImpl.transferBalance(12345, 67890, 1000);
		
	}
}
