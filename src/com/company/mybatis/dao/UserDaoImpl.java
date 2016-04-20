package com.company.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.company.mybatis.pojo.User;

/**
 * <pre>
 *   <p> Project:mybatis </p>
 *   <p> Package:com.company.mybatis.dao </p>
 *   <p> Title:UserDaoImpl</p>
 *   <p> Description:用户Dao层实现类，使用的是原始方法写dao层 </p>
 *   <p> Company: </p>
 * </pre>
 * @author ChenFumin
 * @version 1.0
 */
public class UserDaoImpl implements UserDao{
	
	// 生成SqlSession的会话工厂 
	private SqlSessionFactory sqlSessionFactory;
	
	// 在构造器中注入sqlSessionFactory
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUser", id);
		session.commit();
		session.close();
	}

	@Override
	public void updateUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("test.updateUser", user);
		session.commit();
		session.close();
	}

	@Override
	public User getUserById(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		session.close();
		return user;
	}

	@Override
	public List<User> getUserList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> list = session.selectList("test.findUser");
		session.close();
		return list;
	}
	
}
