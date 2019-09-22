package learnspringcloudmsfastpass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudFasspassMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFasspassMsApplication.class, args);
	}

}
