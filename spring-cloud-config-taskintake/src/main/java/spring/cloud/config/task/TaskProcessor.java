package spring.cloud.config.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {

	@Autowired
	private Source source;
	
	public void sendMessage(String payload) {
		
		String uri="maven://spring.cloud.config.task:spring-cloud-config-task:jar:0.0.1-SNAPSHOT";
		
		List<String> input = new ArrayList<>(Arrays.asList(payload.split(",")));
		
		TaskLaunchRequest request = new TaskLaunchRequest(uri, input, null, null, "toll processor");
		System.out.println("create task request:"+request);
		GenericMessage<TaskLaunchRequest> msg = new GenericMessage<>(request);
		
		source.output().send(msg);
		
		
	}
}
