/**
 * 
 */
package com.cn.pmqin.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cn.pmqin.domain.UserInfo;

/** 
* @author : pmqin
* @date   : 2016年3月31日 上午12:31:36 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserDao {
	//指向UserInfoMapper.xml文件中Select节点下id属性定义的内容.
    private String sql = "com.cn.pmqin.mapping.UserInfoMapper2.selectByPrimaryKey";
    public UserInfo GetUsersAll(int id){
        InputStream is = UserDao.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
//        Connection conn = session.connection();绕过SqlSessionFactory API 可以获取到原始的JDBC
//        PrepareStatement stmt = conn.prepareStatement(insertSql);
        return session.selectOne(sql, id);
    }
}
