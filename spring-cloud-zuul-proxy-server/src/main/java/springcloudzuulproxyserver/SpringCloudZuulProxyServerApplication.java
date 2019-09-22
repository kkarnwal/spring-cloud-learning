package springcloudzuulproxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import springcloudzuulproxyserver.filters.PostFilter;
import springcloudzuulproxyserver.filters.PreFilter;
import springcloudzuulproxyserver.filters.ProxyFilter;

@EnableZuulProxy
@SpringBootApplication
//@EnableEurekaClient
public class SpringCloudZuulProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulProxyServerApplication.class, args);
	}

	@Bean
	public ProxyFilter getFilter() {
		return new ProxyFilter();
	}

	@Bean
	public PreFilter getPreFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter getPostFilter() {
		return new PostFilter();
	}
}
