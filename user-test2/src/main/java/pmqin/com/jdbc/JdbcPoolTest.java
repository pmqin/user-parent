/**
 * 
 */
package pmqin.com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

/** 
* @author : pmqin
* @date   : 2016年9月19日 下午10:01:45 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class JdbcPoolTest {

	JdbcPool pool=DBManager.getInstance();
	@Before
	public void before() {
		pool.init();
	}
	
	
	@Test
	public void selectTest() throws SQLException {
		
		PooledConnection connection=pool.getConnection();
		
		ResultSet rs=connection.queryBysql("select * from bank");
		
		System.out.println("线程名称:"+Thread.currentThread().getName());
		try {
			while (rs.next()) {
				System.out.println("代码=" + rs.getString("代码") + " 名称=" + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs.close();
		connection.close();
		
	}
	
	@Test
	public void threadTest() {
		for (int i = 0; i < 100; i++) {
			
			new Thread(new Runnable() {
				public void run() {
					try {
						selectTest();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	
}
