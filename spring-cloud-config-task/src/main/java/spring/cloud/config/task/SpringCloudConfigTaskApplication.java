package spring.cloud.config.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudConfigTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigTaskApplication.class, args);
	}
	
	@Bean
	public TollTaskProcessing tollTaskProcessing() {
		return new TollTaskProcessing();
	}
	
	public class TollTaskProcessing implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {

			if(null!=args) {
				System.out.println("param length is :"+args.length);
				String stationId = args[1];
				String licensePlate = args[2];
				String timestamp = args[3];
				
				System.out.format("stationId: %s , licensePlate:%s , timestamp:%s", stationId,licensePlate,timestamp);
				
			}
		}
		
		
	}

}
