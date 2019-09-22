package springcloudhystrixturbineserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

//@EnableEurekaClient
@EnableTurbineStream
@SpringBootApplication
public class SpringCloudHystrixTurbineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixTurbineServerApplication.class, args);
	}

}
