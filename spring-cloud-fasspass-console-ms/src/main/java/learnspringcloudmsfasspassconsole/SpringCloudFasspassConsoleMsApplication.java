package learnspringcloudmsfasspassconsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "fastpass-ms", configuration = FallPassMSConfiguration.class)
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudFasspassConsoleMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFasspassConsoleMsApplication.class, args);
	}

}
