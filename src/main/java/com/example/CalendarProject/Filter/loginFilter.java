package com.example.CalendarProject.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class loginFilter implements Filter {
    final String[] WHITE_URL = {"/signup", "/login","logout"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();

        if(!isWhiteUrl(url)){
            HttpSession session = request.getSession(false);

            if(session == null || session.getAttribute("sessionKey") == null){

                log.info("로그인후 사용가능한 기능입니다");
            }

            log.info("로그인되었습니다");
        }

        filterChain.doFilter(request,response);
    }

    private boolean isWhiteUrl(String url){
        return PatternMatchUtils.simpleMatch(WHITE_URL, url);
    }
}
