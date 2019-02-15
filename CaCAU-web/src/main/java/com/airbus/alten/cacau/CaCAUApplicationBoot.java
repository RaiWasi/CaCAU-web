package com.airbus.alten.cacau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.SpringSecurityMessageSource;

import com.airbus.alten.cacau.exception.DefaultExceptionHandler;
import com.airbus.alten.cacau.model.business.CaCAUApplicationContext;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationBusinessContext;
import com.airbus.alten.cacau.model.business.UseCaseConfigurationContext;
import com.airbus.alten.cacau.model.business.UserCaCAUContext;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.airbus.alten.cacau" })
@EnableJpaRepositories({ "com.airbus.alten.cacau" })
@EntityScan({ "com.airbus.alten.cacau" })
public class CaCAUApplicationBoot extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CaCAUApplicationBoot.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CaCAUApplicationBoot.class, args);
	}

	@Bean(name = "caCAUApplicationContext")
	public CaCAUApplicationContext caCAUApplicationContext() {
		return new CaCAUApplicationContext();
	}

	@Bean(name = "userCaCAUContext")
	public UserCaCAUContext userCaCAUContext() {
		return new UserCaCAUContext();
	}

	@Bean(name = "caCAUUseCaseConfigurationContext")
	public UseCaseConfigurationContext caCAUUseCaseConfigurationContext() {
		return new UseCaseConfigurationContext();
	}

	@Bean(name = "useCaseConfigurationBusinessContext")
	public UseCaseConfigurationBusinessContext useCaseConfigurationBusinessContext() {
		return new UseCaseConfigurationBusinessContext();
	}
	
	@Bean(name = "defaultExceptionHandler")
	public DefaultExceptionHandler defaultExceptionHandler() {
		MessageSourceAccessor msgs = SpringSecurityMessageSource.getAccessor();
		return new DefaultExceptionHandler(msgs);
	}
	
}
