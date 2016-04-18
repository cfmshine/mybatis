package com.company.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.company.mybatis.pojo.User;

public class MybatisFirst {
	
	SqlSession ss;

	@Before
	public void init() throws Exception {
		// 加载配置文件
		InputStream rs = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 1.创建一个sqlSessionFactory回话工厂
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(rs);

		// 2.通过sqlSessionFactory获取sqlSession
		ss = ssf.openSession();
	}

	@Test
	public void testFindUserById() throws Exception {

		// 加载配置文件
		InputStream rs = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 1.创建一个sqlSessionFactory回话工厂
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(rs);

		// 2.通过sqlSessionFactory获取sqlSession
		SqlSession ss = ssf.openSession();

		// 3.通过sqlSession来操作数据库
		// selectOne
		// d第一个参数:是namespace + "." + mapper的id
		// 第二个参数:需要传递的参数值
		User user = ss.selectOne("test.findUserById", 1);

		System.out.println(user);

		ss.close();
	}
	
	@Test
	public void testfindUserByName(){
		List<User> users = ss.selectList("test.findUserByName", "小明");
		System.out.println(users);
		ss.close();
	}

}
