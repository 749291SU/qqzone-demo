package com.siwen.qqzone.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @projectName: JavaWeb
 * @package: siwen.filters
 * @className: EncodingFilter
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 1:31 PM
 * @version: 1.0
 */

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
