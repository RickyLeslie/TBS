package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFilter implements Filter{
	
	private List<String> passView;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		passView=Arrays.asList(filterConfig.getInitParameter("passView").split(","));
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		ServletContext servletContext=httpServletRequest.getServletContext();
		//当前请求的资源名称
		String uri=httpServletRequest.getRequestURI();
		uri=uri.substring(uri.indexOf("/",2));
		System.out.println("uri :"+uri);
		
		//如果用户请求的资源不在排除过滤资源之内(登陆注册),拦截除了登陆,注册界面的所有请求访问
		if(!passView.contains(uri)){
			//返回登陆界面
			httpServletResponse.sendRedirect("/login.jsp");
		}
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
