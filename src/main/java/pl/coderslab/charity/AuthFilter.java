package pl.coderslab.charity;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) servletRequest;
       HttpServletResponse resp = (HttpServletResponse) servletResponse;
       HttpSession session = req.getSession();
       if(session.getAttribute("user") != null){
           filterChain.doFilter(servletRequest,servletResponse);
       }
        System.out.println("działam - filtruje");
       resp.sendRedirect("/login");


    }
}
