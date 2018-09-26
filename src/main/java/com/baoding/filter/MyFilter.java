package com.baoding.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/myUI","/note/add","/comment/add"})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        if (request1.getSession().getAttribute("user")!=null){
            chain.doFilter(request1,response1);
        }else {
            response1.sendRedirect("/user/loginUI");
        }

    }

    @Override
    public void destroy() {

    }
}
