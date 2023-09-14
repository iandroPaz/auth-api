package com.auth.authapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//import com.auth.authapi.interceptor.AuthInterceptor;

@SpringBootApplication //(exclude = {HibernateJpaAutoConfiguration.class})
@EnableJpaAuditing
@EnableJpaRepositories
@ConfigurationProperties("com.auth.authapi")
public class AuthApiApplication { //implements WebMvcConfigurer {
	//@Autowired
	//@Lazy
	//private AuthInterceptor interceptor;

	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}


	//@Override public void addInterceptors(InterceptorRegistry registry) {
	//registry.addInterceptor((HandlerInterceptor) interceptor).addPathPatterns("/auth/**"); }


}