package learnspringcloudmsfasspassconsole;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastPassRestController {

	@Autowired
	private TollSource tollSource;

	@RequestMapping(path = "/toll", method = RequestMethod.POST)
	public String publishMsg(@RequestBody String payload) {
		Random r = new Random();
		tollSource.fassPassToll().send(MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(2)).build());
		System.out.println("sending payload:" + payload);
		return "success";
	}
}
