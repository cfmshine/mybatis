package com.company.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.company.mybatis.pojo.User;
import com.company.mybatis.pojo.User1;

/**
 * <p> Title:MybatisFirst.java </p>
 * <p> Description:第一个mybatis方法 </p>
 * <p> Company: </p>
 *
 * @author ChenFumin
 * @version 1.0
 */
public class MybatisFirst {
	
	/**
	 * <p>method_name:testFindUserById</p>
	 * <p>Description:根据id查询一个用户</p>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
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
	
	/**
	 * <p>method_name:testfindUserByName</p>
	 * <p>Description:根据名字获取用户，模糊查询</p>
	 *
	 * @author ChenFumin
	 * @throws Exception 
	 *
	 */
	@Test
	public void testfindUserByName() throws Exception{
		// 加载配置文件
		InputStream rs = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 1.创建一个sqlSessionFactory回话工厂
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(rs);

		// 2.通过sqlSessionFactory获取sqlSession
		SqlSession ss = ssf.openSession();
		
		// 查询
		List<User> users = ss.selectList("test.findUserByName", "小明");
		
		// 查看查询结果
		System.out.println(users);
		
		// 关闭连接
		ss.close();
	}
	
	/**
	 * <p>method_name:insertUserTest</p>
	 * <p>Description:插入一个用户</p>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	@Test
	public void insertUserTest() throws Exception{
		// 1.获取配置文件的流
		String config = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		// 2.创建会化工厂sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过会话工厂创建sqlSession
		SqlSession ss = ssf.openSession();
		
		// 创建一个用户对象，用于保存到数据库
		User user = new User();
		user.setAddress("北京延庆");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("陈星亮");
		
		// 4.通过session来操作数据库
		ss.insert("test.insertUser", user);
		
		// 5. 提交事务
		ss.commit();
		
		// 获取最新插入数据的主健值:通过配置<selectKey></selectKey>
		System.out.println(user.getId());
		
		// 6.关闭连接
		ss.close();
	}
	
	/**
	 * <p>method_name:insertUserTest1</p>
	 * <p>Description:测试主键非自增的主键UUID</p>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	@Test
	public void insertUserTest1() throws Exception{
		// 1.获取配置文件的流
		String config = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		// 2.创建会化工厂sqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过会话工厂创建sqlSession
		SqlSession ss = ssf.openSession();
		
		// 创建一个用户对象，用于保存到数据库
		User1 user = new User1();
		user.setAddress("北京延庆");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("陈星亮");
		
		// 4.通过session来操作数据库
		ss.insert("test.insertUser1", user);
		
		// 5. 提交事务
		ss.commit();
		
		// 获取最新插入数据的主健值:通过配置<selectKey></selectKey>
		System.out.println(user.getId());
		
		// 6.关闭连接
		ss.close();
	}
	
	/**
	 * <p>method_name:deleteUserTest</p>
	 * <p>Description:根据Id删除对用的user</p>
	 *
	 * @author ChenFumin
	 *
	 * @throws IOException
	 */
	@Test
	public void deleteUserTest() throws IOException{
		
		// 获取配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建会话工厂SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// 根据ssf创建SqlSession
		SqlSession session = ssf.openSession();
		
		// 通过session操作数据库，删除用户
		session.delete("test.deleteUser", 31);
		
		// 提交事务
		session.commit();
		
		// 关闭连接
		session.close();
		
	}
	
	/**
	 * 
	 * <p>method_name:updateUserTest</p>
	 * <p>Description:更新用户</p>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	@Test
	public void updateUserTest() throws Exception{
		
		// 获取配置文件流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获取会话工厂SqlsessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过ssf获取session
		SqlSession session = ssf.openSession();
		
		// 首先获取一个用户信息
		User user = session.selectOne("test.findUserById", 29);
		
		user.setAddress("河南驻马店");
		
		// 通过session操作数据库，修改用户
		session.update("test.updateUser", user);
		
		session.commit();
		
		session.close();
		
	}

}
