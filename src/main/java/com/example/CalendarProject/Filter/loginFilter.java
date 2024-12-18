package com.example.CalendarProject.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class loginFilter implements Filter {
    final String[] WHITE_URL = {"/","/calendar/customer/signup", "/calendar/customer/login", "/calendar/customer/logout", };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        System.out.println(url);

        if (!isWhiteUrl(url)) {
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("sessionKey") == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                log.info("로그인이 필요한 기능입니다");
                return;

            } else {
                log.info("로그인되었습니다");
            }
        }


        filterChain.doFilter(request, response);
    }

    private boolean isWhiteUrl(String url) {
        return PatternMatchUtils.simpleMatch(WHITE_URL, url);
    }
}
