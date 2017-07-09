/**
 * 
 */
package pmqin.com.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

/** 
* @author : pmqin
* @date   : 2016年9月19日 下午9:01:44 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class JdbcPool implements IPool {

	private static String jdbcDriver = "";
	private static String dbUserNmae = "";
	private static String dbpassword = "";
	private static String dburl = "";
	private static int initconncount;
	private static int maxConncount;
	private static int incrementcount;

	private Vector<PooledConnection> vector = new Vector<PooledConnection>();

	public void init() {
		InputStream inStream = JdbcPool.class.getClassLoader().getResourceAsStream("jdbc.properties");

		Properties properties = new Properties();
		try {
			properties.load(inStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		jdbcDriver = properties.getProperty("driver");
		dbUserNmae = properties.getProperty("name");
		dbpassword = properties.getProperty("password");
		dburl = properties.getProperty("url");
		initconncount =Integer.valueOf(properties.getProperty("initconncount"));
		maxConncount = Integer.valueOf(properties.getProperty("maxconncount"));
		incrementcount = Integer.valueOf(properties.getProperty("incrementcount"));
		
		
		try {
			Driver driver = (Driver) Class.forName(jdbcDriver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public synchronized PooledConnection getConnection() {

		if (vector.size() <= 0) {
			System.out.println("连接池没有连接");
			throw new RuntimeException("连接池没有连接");

		}

		PooledConnection connection=getActiveConnection();
		//null 等于连接池都是忙碌的状态
		if (connection==null) {
			//增加连接
			createConnection(incrementcount);
			connection=getActiveConnection();
			if (connection==null) {
				
				
			}
			
		}
		
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pmqin.com.jdbc.IPool#createConnection(int)
	 */
	@Override
	public void createConnection(int count) {
		for (int i = 0; i < count; i++) {

			if (maxConncount > 0 && vector.size() >= maxConncount) {

			}
		}
	}

	private PooledConnection getActiveConnection() {
		for (PooledConnection conn : vector) {
			if (!conn.getIsBusy()) {

				Connection connection = conn.getConn();
				
				//connection.isValid(arg0)

			}
		}

		return null;
	}
}
