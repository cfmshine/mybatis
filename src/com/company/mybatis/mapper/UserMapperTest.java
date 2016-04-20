package com.company.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.company.mybatis.pojo.User;

public class UserMapperTest {

	SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 初始化SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetUserById() throws Exception {
		SqlSession ss = sqlSessionFactory.openSession();
		
		UserMapper mapper = ss.getMapper(UserMapper.class);
		
		User user = mapper.findUserById(30);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() throws Exception {
		SqlSession ss = sqlSessionFactory.openSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<User> list = mapper.findUserByName("小明");
		System.out.println(list);
	}

}
