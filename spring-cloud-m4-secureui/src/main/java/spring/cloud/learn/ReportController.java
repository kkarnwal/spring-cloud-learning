package spring.cloud.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController {

	
	@Autowired
	private OAuth2ClientContext auth2ClientContext;
	
	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}
	
	@RequestMapping("/reports")
	public String loadReport() {
		OAuth2AccessToken accessToken = auth2ClientContext.getAccessToken();
		System.out.println("accessToken = "+accessToken.getValue());
		
		return "reports";
		
		
		
	}
}
