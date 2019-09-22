package springcloudhystrixserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class SpringCloudHystrixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixServerApplication.class, args);
	}

}
