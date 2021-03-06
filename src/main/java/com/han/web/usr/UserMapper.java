package com.han.web.usr;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.han.web.usr.User;

@Repository
public interface UserMapper {
	public int rowCount();
	public void insertUser(User user);
	public User selectUserByIdPw(User user);
	public int existId(String uid);
	public int countUsers();
	public void createUser(HashMap<String, String> paramMap);
	public void dropUser(HashMap<String, String> paramMap);
	public void createDB(HashMap<String, String> paramMap);
	public void createRes(HashMap<String, String> paramMap);
	public void createLolTable(HashMap<String, String> paramMap);
	public void createReportTable(HashMap<String, String> paramMap);
	public void createShipDb(HashMap<String,String> map);
	public void truncateUser(HashMap<String, String> paramMap);
	public List<User> selectAll();
}
