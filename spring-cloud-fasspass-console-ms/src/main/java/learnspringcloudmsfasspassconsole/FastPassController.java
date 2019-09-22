package learnspringcloudmsfasspassconsole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FastPassController {

//	@Autowired
//	private LoadBalancerClient loadBalancerClient;

	@LoadBalanced
	@Bean
	public RestTemplate resttemplateBuilder(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

//	@HystrixCommand(fallbackMethod = "getFastPassCustomerBackup")
	@RequestMapping(path = "/customerdetails", params = { "fastpassid" })
	public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
//		ServiceInstance choose = loadBalancerClient.choose("stores");
//		System.out.println("service: uri:" + choose.getUri().toString());
//		RestTemplate rest = new RestTemplate();
//		FastPassCustomer c = restTemplate.getForObject(
//				choose.getUri().toString() + "/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
		FastPassCustomer c = restTemplate.getForObject("http://FASTPASS-MS/fastpass?fastpassid=" + fastpassid,
				FastPassCustomer.class);
		System.out.println("retrieved customer details");
		m.addAttribute("customer", c);
		return "console";
	}

	public String getFastPassCustomerBackup(@RequestParam String fastpassid, Model m) {
		System.out.println("fallback customer fast pass failed!");
		FastPassCustomer cus = new FastPassCustomer();
		cus.setFastPassId(fastpassid);
		m.addAttribute("customer", cus);
		return "console";
	}
}
