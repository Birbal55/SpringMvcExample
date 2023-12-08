package springmvcexample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptorAdaptor;

public class MyInterceptor extends HandlerInterceptorAdaptor{

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
	throws Exception{
		System.out.println("this is prehandler..");
		
		String name = request.getParameter("user");
		if(name.startsWith("d")) {
			response.setContentType("text/html");
			response.getWriter().println("<h1>Invalid name.. Name should not start with d</h1>");
			return false;
		}
		return true;
	}
	
	public boolean postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)
			throws Exception{
				System.out.println("this is posthandler..");
				
				super.postHandle(request,response,handler,modelAndView);
			}
	
	public boolean afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,)
			throws Exception{
				System.out.println("this is completion method..");
				super.postHandle(request,response,handler,ex);
				
				
			}
}
