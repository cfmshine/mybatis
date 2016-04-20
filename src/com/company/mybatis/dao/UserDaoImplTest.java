package com.company.mybatis.dao;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.company.mybatis.pojo.User;

public class UserDaoImplTest {
	
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 初始化SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User(100, "胡森", "1", new Date(), "北京大兴");
		userDao.insertUser(user);
	}

	@Test
	public void testGetUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.getUserById(30);
		System.out.println(user);
	}

	@Test
	public void testGetUserList() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> userList = userDao.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
