package com.yifengtec.springboot.hello.web;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yifengtec.springboot.hello.util.MD5Util;
import com.yifengtec.springboot.hello.web.vo.PostOnceReq;

@RestController
public class PostOnceController {

	@Resource(name = "commonCacheRedisTemplate")
	private RedisTemplate commonCacheRedisTemplate;

	@RequestMapping(path = "/gettoken", method = RequestMethod.GET)
	public Object gettoken(@RequestBody PostOnceReq req) throws Exception {
		// 生成请求对应的唯一token
		String token = MD5Util.string2MD5(req.toString());
		// 初始化值
		byte[] old = commonCacheRedisTemplate.getConnectionFactory().getConnection().get(token.getBytes());
		String oldStr = new String(old);
		if (old == null) {
			commonCacheRedisTemplate.getConnectionFactory().getConnection().set(token.getBytes(), "1".getBytes());
			commonCacheRedisTemplate.getConnectionFactory().getConnection().expire(token.getBytes(), 30l);
		}
		return token;
	}

	@RequestMapping(path = "/doaction")
	public Object testToken() throws Exception {
		commonCacheRedisTemplate.getConnectionFactory().getConnection().set("a".getBytes(), "123".getBytes());
		byte[] result = commonCacheRedisTemplate.getConnectionFactory().getConnection().get("a".getBytes());
		String key = new String(result);
		return key;
	}
}
