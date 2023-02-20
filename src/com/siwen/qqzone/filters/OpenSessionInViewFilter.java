package com.siwen.qqzone.filters;

import com.siwen.qqzone.trans.TransactionManager;

import javax.servlet.*;
import java.io.IOException;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.filters
 * @className: OpenSessionInViewFilter
 * @author: 749291
 * @description: TODO
 * @date: 2/18/2023 3:39 PM
 * @version: 1.0
 */

public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransactionManager.openTrans();
            filterChain.doFilter(servletRequest, servletResponse);
            TransactionManager.commit();
        } catch (Exception e) {
            try {
                TransactionManager.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
