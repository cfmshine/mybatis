package com.company.mybatis.dao;

import java.util.List;

import com.company.mybatis.pojo.User;

/**
 * <pre>
 *   <p> Project:mybatis </p>
 *   <p> Package:com.company.mybatis.dao </p>
 *   <p> Title:UserDao</p>
 *   <p> Description:用户dao层的接口 ,利用原始的dao方法来写</p>
 *   <p> Company: </p>
 * </pre>
 * 
 * @author ChenFumin
 * @version 1.0
 */
public interface UserDao {

	/**
	 * <pre>
	 *   <p> Head:UserDao.java </p>
	 *   <p> Title:insertUser </p>
	 *   <p> Description:插入一个用户 </p>
	 * </pre>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	void insertUser(User user) throws Exception;
	
	/**
	 * <pre>
	 *   <p> Head:UserDao.java </p>
	 *   <p> Title:deleteUser </p>
	 *   <p> Description:删除一个用户 </p>
	 * </pre>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	void deleteUser(int id) throws Exception;
	
	/**
	 * <pre>
	 *   <p> Head:UserDao.java </p>
	 *   <p> Title:updateUser </p>
	 *   <p> Description:更新一个用户 </p>
	 * </pre>
	 *
	 * @author ChenFumin
	 *
	 * @throws Exception
	 */
	void updateUser(User user) throws Exception;
	
	/**
	 * <pre>
	 *   <p> Head:UserDao.java </p>
	 *   <p> Title:getUserById </p>
	 *   <p> Description:根据Id查询一个用户 </p>
	 * </pre>
	 *
	 * @author ChenFumin
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getUserById(int id) throws Exception;
	
	/**
	 * <pre>
	 *   <p> Head:UserDao.java </p>
	 *   <p> Title:getUserList </p>
	 *   <p> Description:获取一组用户 </p>
	 * </pre>
	 *
	 * @author ChenFumin
	 *
	 * @return
	 * @throws Exception
	 */
	List<User> getUserList() throws Exception;
	
}
