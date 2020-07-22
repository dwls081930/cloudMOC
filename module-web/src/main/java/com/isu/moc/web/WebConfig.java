package com.isu.moc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "httpInterceptor")
    private HandlerInterceptor interceptor;

    @Autowired
    private WebSocketHandler mocWebSocketHandler;

    @Bean
    public MappingJackson2JsonView jsonView() {
        // ex) ModelAndView mv = new ModelAndView("jsonView");
        return new MappingJackson2JsonView();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index");
    }

}
