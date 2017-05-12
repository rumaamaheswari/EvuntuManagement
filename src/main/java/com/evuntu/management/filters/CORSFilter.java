package com.evuntu.management.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author umaam
 *
 */
public class CORSFilter implements Filter {
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, HEAD, OPTIONS");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me");
				//"X-User-Id, X-Application-Access-Key, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

		request.getSession();

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) {

	}

	@Override
	public void destroy() {
		/* empty */
	}

}
