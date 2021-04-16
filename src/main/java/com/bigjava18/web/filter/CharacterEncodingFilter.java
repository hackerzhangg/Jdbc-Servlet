package com.bigjava18.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author zgp
 * @Since 2021 -04 -16 10 :08
 * @Description 处理中文乱码Filter
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding=null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding=filterConfig.getInitParameter("encoding");
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        if(encoding !=null){
            servletRequest.setCharacterEncoding(this.encoding);
            servletResponse.setCharacterEncoding(this.encoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
