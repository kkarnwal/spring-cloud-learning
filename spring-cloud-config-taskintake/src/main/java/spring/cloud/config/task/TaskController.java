package spring.cloud.config.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired
	private TaskProcessor t;
	
	@RequestMapping(value = "/task",method = RequestMethod.POST)
	public String launchTask(@RequestBody String body) {
		t.sendMessage(body);
		
		System.out.println("request sent");
		
		return "success";
	}
}
