/**
 * 
 */
package pmqin.com.jdbc;
/** 
* @author : pmqin
* @date   : 2016年9月19日 下午9:55:17 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class DBManager {

	private static class createPool
	{
		private static JdbcPool pool=new JdbcPool();
	}
	
	public static JdbcPool getInstance()
	{
		return createPool.pool;
	}
	
}
