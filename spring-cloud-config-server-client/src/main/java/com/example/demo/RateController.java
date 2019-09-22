package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RefreshScope
public class RateController {

	@Value("${rate}")
	String rate;
	@Value("${lanecount}")
	String laneCount;
	@Value("${tollstart}")
	String tollStart;
	@Value("${consstring}")
	String consString;
	
	@RequestMapping(value = "/rate")
	public String getRate(Model m) {
		
		m.addAttribute("rate", rate);
		m.addAttribute("laneCount", laneCount);
		m.addAttribute("tollStart", tollStart);
		m.addAttribute("consstring", consString);
		
		return "rateview";
	}
	
}
