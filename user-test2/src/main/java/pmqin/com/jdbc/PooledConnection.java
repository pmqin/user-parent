/**
 * 
 */
package pmqin.com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/** 
* @author : pmqin
* @date   : 2016年9月19日 下午9:02:50 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class PooledConnection {
    private Boolean isBusy;
	private Connection conn = null;

	public PooledConnection()
	{
	}
	
	public ResultSet queryBysql(String sql) {
		
		Statement statement=null;
		ResultSet rSet=null;
		try {
			statement=(Statement) conn.createStatement();
			rSet=statement.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	}
	
	public PooledConnection(Connection conn ,Boolean isBusy)
	{
		this.conn=conn;
		this.isBusy=isBusy;
	}
	public Boolean getIsBusy() {
		return isBusy;
	}

	public void setIsBusy(Boolean isBusy) {
		this.isBusy = isBusy;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void close() {
		isBusy=false;
	}
}
