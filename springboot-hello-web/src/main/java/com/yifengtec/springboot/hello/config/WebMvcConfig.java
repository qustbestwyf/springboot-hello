package com.yifengtec.springboot.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.AppCacheManifestTransformer;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import com.yifengtec.springboot.hello.advice.PermissionInterceptor;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		return new ResourceUrlEncodingFilter();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

		boolean devMode = this.env.acceptsProfiles("dev");
		boolean useResourceCache = !devMode;
		Integer cachePeriod = devMode ? 0 : null;
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").setCachePeriod(cachePeriod)
				.resourceChain(useResourceCache).addResolver(new GzipResourceResolver())
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**")
						.addFixedVersionStrategy("v100", "/v100/js/**"))
				.addTransformer(new AppCacheManifestTransformer());

	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**");
	}
}
