package com.han.web.usr;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.han.web.pxy.Box;
import com.han.web.pxy.Proxy;

@RestController
@RequestMapping("/users")
public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	
	@Autowired UserMapper userMapper;
	@Autowired Box<Integer> box;
	@Autowired Proxy pxy;
	
	public int rowCount() {
		int rowCount = userMapper.rowCount();
		pxy.printer("rowCount"+rowCount);
		box.put("rowCount", rowCount);
		return box.get("rowCount");
		
	}

}
