package com.auth.authapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import com.auth.authapi.interceptor.AuthInterceptor;

@SpringBootApplication //(exclude = {HibernateJpaAutoConfiguration.class})
//@EnableJpaAuditing
//@EnableJpaRepositories
//@ConfigurationPropertiesScan("com.auth.authapi")
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