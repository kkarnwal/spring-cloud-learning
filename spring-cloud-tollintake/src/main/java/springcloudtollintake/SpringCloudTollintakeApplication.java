package springcloudtollintake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//@EnableBinding(Processor.class)
@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringCloudTollintakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTollintakeApplication.class, args);
	}

	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] >40")
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
	public void fassMsg(String msg) {
		System.out.println("fast:" + msg);
//		return msg;
	}

	@StreamListener(value = Sink.INPUT, condition = "headers['speed'] <=40")
	public void slowMsg(String msg) {
		System.out.println("slow:" + msg);
	}

}
