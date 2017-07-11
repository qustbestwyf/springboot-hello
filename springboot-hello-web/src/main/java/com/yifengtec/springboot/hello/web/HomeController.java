package com.yifengtec.springboot.hello.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import com.yifengtec.springboot.hello.annotation.PermissionCheck;

@RestController
public class HomeController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ResourceUrlProvider resourceUrlProvider;

	@Resource(name = "commonCacheRedisTemplate")
	private RedisTemplate commonCacheRedisTemplate;

	@RequestMapping(path = "/")
	@PermissionCheck("xx")
	public Object welcome() throws Exception {
		String url = resourceUrlProvider.getForLookupPath("/styles/homepage.css");
		logger.info("现在我用配置文件的方式咯");
		return url;
	}

	@RequestMapping(path = "/testRedis")
	public Object testRedis() throws Exception {
		commonCacheRedisTemplate.getConnectionFactory().getConnection().set("a".getBytes(), "123".getBytes());
		byte[] result = commonCacheRedisTemplate.getConnectionFactory().getConnection().get("a".getBytes());
		String key = new String(result);
		return key;
	}

}
