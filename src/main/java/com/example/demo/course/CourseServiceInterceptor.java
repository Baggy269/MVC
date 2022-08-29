package com.example.demo.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CourseServiceInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(CourseServiceInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String pathParam = request.getRequestURL().toString()
                .replace("http://localhost:8080/courses","");
        String info = "Making a "+request.getMethod()+" request";
        if(!pathParam.equals(""))
            info += " Path parameter: "+pathParam;
        logger.info(info);
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        logger.info("######################");
    }
}
