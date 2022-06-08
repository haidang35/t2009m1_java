package com.example.ecommercever1.filter;

import com.example.ecommercever1.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilterServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        boolean hasPermission = false;
        Account account = (Account) session.getAttribute("currentAccount");
        if(account.getRoleId() == 1) {
            hasPermission = true;
        }
        if(hasPermission) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else {
            httpServletResponse.getWriter().print("Permission denied !!");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
