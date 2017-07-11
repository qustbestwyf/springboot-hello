package com.yifengtec.springboot.hello.config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.Servlet;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(ResourceProperties.class)
public class AppConfig {
	@Autowired(required = false)
    private List<ErrorViewResolver> errorViewResolvers;
	
    private final ServerProperties serverProperties;
    
    public AppConfig(
            ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }
    
//    @Bean
//    public MyErrorController basicErrorController(ErrorAttributes errorAttributes) {
//        return new MyErrorController(errorAttributes, this.serverProperties.getError(),
//                this.errorViewResolvers);
//    }
    
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
     TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
     factory.setPort(9000);
     factory.setSessionTimeout(10, TimeUnit.MINUTES);
     return factory;
    }
    
}
