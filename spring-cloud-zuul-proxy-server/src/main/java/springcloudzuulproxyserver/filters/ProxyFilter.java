package springcloudzuulproxyserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ProxyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		boolean isMobile = false;
		RequestContext ctx = RequestContext.getCurrentContext();

		String parameter = ctx.getRequest().getParameter("source");
		if (parameter != null && parameter.equals("mobile")) {
			isMobile = true;
		}
		return isMobile;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("calling a filter");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

}
