
package pmqin.com.jdbc;


public interface IPool {
	
	 PooledConnection getConnection();
	 void createConnection(int count);
}
