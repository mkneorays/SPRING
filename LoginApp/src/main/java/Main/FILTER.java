package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class FILTER implements Filter {

    /**
     * Default constructor. 
     */
    public FILTER() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("done.......");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("userId");
		String password=request.getParameter("password");
		Pattern p=Pattern.compile("[0-9]{1,5}");
		Matcher m=p.matcher(uid);
		Pattern p1=Pattern.compile("[0-9a-zA-Z@!#$%^&*()_+{}|:?></.,']{5,15}");
		Matcher m1=p1.matcher(password);
		if(!m.find())
		{
			out.println("plz enter the valid userid....");
			
		}
		
		else if(!m1.find())
		{
			out.println("plz enter the valid password....");
		}
		else
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String init=fConfig.getInitParameter("init");
		System.out.println(init);
	}

}
