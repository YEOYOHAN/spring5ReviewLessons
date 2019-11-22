package com.han.web.hdl;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.han.web.usr.User;

@Repository
@Transactional
public interface UserHandler {
	@Insert("insert into USER(USERID, USERNAME, USERPW,"+
            " VALUES (#{uid},#{uname},#{upw})")
	public void insertUser(User u);	
}
