package spring.cloud.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication

public class SpringCloudM4SecureuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM4SecureuiApplication.class, args);
	}

}
