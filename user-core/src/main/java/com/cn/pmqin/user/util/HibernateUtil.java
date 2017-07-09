package com.cn.pmqin.user.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/** 
* @author : pmqin
* @date   : 2015年12月27日 下午4:06:15 
* @version 1.0 
* @parameter  
*/

/**
 * @author pmqin
 *
 */
public class HibernateUtil {
	
public static SessionFactory sf=null;
	
	public HibernateUtil(){}
    
	/**
	 * 插入数据
	 * @param table
	 */
	public static void insert(Object table){
		openSessionFactory();
		Session s = null;
		Transaction t = null;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			s.save(table);
			t.commit();
			s.close();
		}catch(Exception err){
			t.rollback();
			err.printStackTrace();
		}
	}
	
	/**
	 * 更新数据
	 * @param table
	 */
	public static void update(Object table){
		openSessionFactory();
		Session s = null;
		Transaction t = null;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			s.update(table);
			t.commit();
			s.close();
		}catch(Exception err){
			t.rollback();
			err.printStackTrace();
		}
	}
	
	/**
	 * 删除数据
	 * @param table
	 */
	public static void delete(Object table){
		openSessionFactory();
		Session s = null;
		Transaction t = null;
		try{
			s = sf.openSession();
			t = s.beginTransaction();
			s.delete(table);
			t.commit();
			s.close();
		}catch(Exception err){
			t.rollback();
			err.printStackTrace();
		}
	}
	
	/**
	 * 删除多条数据
	 * @param deleteHql
	 */
	public static void delete(String deleteHql){
		openSessionFactory();
		Session session=sf.openSession();
		Object record=null;
		Query query = session.createQuery(deleteHql);
		query.executeUpdate();
		session.close();
	}
	
	/**
	 * 根据主键得到单条记录
	 * @param session
	 * @param hqlWithKey
	 * @param useQueryCache
	 * @return
	 */
	public static Object getRecorderByKey(String hqlWithKey,boolean useQueryCache){
		openSessionFactory();
		Session session=sf.openSession();
		Object record=null;
		Query query = session.createQuery(hqlWithKey);
		//是否使用二级缓存查询,xxx.hbm.xml必须配合使用<cache usage="read-write"/>
		if(useQueryCache==true) query.setCacheable(true);
		List<Object> list = query.list();
		if(list!=null) record=list.get(0);
		session.close();
		return record;
	}
	
	/**
	 * 得到数据集
	 * @param hql
	 * @param startRecord 起始记录数(分页)
	 * @param maxRecords 最大记录数(分页)
	 * @return
	 */
	public static List<Object> getRecorderList(String hql,Integer startRecord,Integer maxRecords,boolean useQueryCache){
		openSessionFactory();
		Session session=sf.openSession();
		Query query = session.createQuery(hql);
		if(useQueryCache==true) query.setCacheable(true);
		//分页
		if(startRecord!=null && maxRecords!=null){
			query.setFirstResult(startRecord);
			query.setMaxResults(maxRecords);
		}
		List<Object> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 创建连接工厂，一般在应用程序初始化时执行该方法
	 */
	public static void openSessionFactory(){
		if(sf==null) sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	/**
	 * 关闭连接工厂，由于开销很大，一般应用程序只会在整个程序要关闭前执行该方法
	 */
	public static void closeSessionFactory(){
		if(sf!=null){
			sf.close();
			sf=null;
		}
	}
}
