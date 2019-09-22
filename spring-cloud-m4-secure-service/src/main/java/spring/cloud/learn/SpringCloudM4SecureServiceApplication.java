package spring.cloud.learn;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudM4SecureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM4SecureServiceApplication.class, args);
	}
	
	@RequestMapping("/tolldata")
	public List<TollUsage> getTollUsages(){
	
		TollUsage t1 = new TollUsage("100", "station-1", "hw4748", "2019-07-18T06:31:22");
		TollUsage t2 = new TollUsage("101", "station-2", "hw4748", "2019-07-18T06:31:22");
		
		return Arrays.asList(t1,t2);
	}
	
	public class TollUsage implements Serializable{
		
		String id;
		String stationId;
		String licensePlate;
		String timestamp;
		
		public TollUsage() {
			
		}

		public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
			super();
			this.id = id;
			this.stationId = stationId;
			this.licensePlate = licensePlate;
			this.timestamp = timestamp;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getStationId() {
			return stationId;
		}

		public void setStationId(String stationId) {
			this.stationId = stationId;
		}

		public String getLicensePlate() {
			return licensePlate;
		}

		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		
		
		
		
	}
	

}
