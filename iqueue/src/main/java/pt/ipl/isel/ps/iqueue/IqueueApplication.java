package pt.ipl.isel.ps.iqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IqueueApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry
//						.addMapping("/**")
////						.allowCredentials(true)
//						.allowedOrigins("*")
//						.allowedMethods("*")
//						.allowedHeaders("*");
//			}
//		};
//	}

}
