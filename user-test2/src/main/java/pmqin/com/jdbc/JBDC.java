package pmqin.com.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Hello world!
 *
 */
public class JBDC {
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String password = "123456";

	public static void main(String[] args) {
		System.out.println("Hello World!");
		//TestInsert();
		createConnection();
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection createConnection() {

		// JDBC实现往MySQL插入百万级数据 http://www.cnblogs.com/fnz0/p/5713102.html  做一下

		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(url, user, password);

			// 查询记录
			// 不带参数查询
			// String sql = "select * from bank";
			// Statement stmt1 = (Statement) conn.createStatement();
			//
			// ResultSet rs = stmt.executeQuery(sql);
			// while (rs.next()) {
			// if (rs.getString(1) != null)
			//
			// System.out.println("username=" + rs.getString(2) + " age=" +
			// rs.getString(3));
			// }
			//// 带参数查询记录
			String sql = "select * from tb_grade_info where id=?";// where
																	// username=?
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			// stmt.setInt(1, 1);
			stmt.setInt(1, 7);
			ResultSet rs = stmt.executeQuery();
			rs.getMetaData();
			while (rs.next()) {
				if (rs.getString(1) != null)

					System.out.println("代码=" + rs.getString("id") + " 名称=" + rs.getString(3));
			}

			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i);
				String columnTypeName =rsmd.getColumnTypeName(i);
				int columnTypeclass =rsmd.getColumnType(i);
				String value = String.format(columnName);
				System.out.println("columnName:" + value+"-----columnTypeName:"+columnTypeName+"---"+columnTypeclass);
			}

			// 更新记录
			sql = "update tb_grade_info set subject_id=?  where id=1";
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, 1989);
			stmt.executeUpdate();

			// 删除记录
			sql = "delete from  tb_grade_info   where id=?";
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			int row = stmt.executeUpdate();
			// stmt.addBatch();
			// stmt.executeBatch();
			System.out.println("成功删除" + row + " 记录");

			// 调用存储过程 //#CALL sp_SelectStock(1,11,20,100,15,100);
			// 更多带参数，返回值的形式http://blog.csdn.net/zhangdaiscott/article/details/5973983
			// CallableStatement cStmt = (CallableStatement)
			// conn.prepareCall("call sp_SelectStock(1,11,20,100,15,100)");
			// int rowc = cStmt.executeUpdate();
			// System.out.println("成功获取" + rowc + " 记录");
			// 这个方式也可以
			// boolean b = cStmt.execute();
			// System.out.println("成功获取" + b + " 记录");

			// ResultSet crs = cStmt.getResultSet();// 不能共存getMoreResults
			// while (crs.next()) {
			// if (crs.getString(1) != null)
			//
			// System.out.println("存储过程执行的代码=" + crs.getString("代码") + " 名称=" +
			// crs.getString(3));
			// }

			// Smart Insert: Batch within Batch - 智能插入：将整批分批
			// 这是一个简单的解决方案。考虑批量大小为1000，每1000个查询语句为一批插入提交。
			// 在执行批量插入的时候最主要的是将自动提交取消
			// https://my.oschina.net/u/1452675/blog/203670
			// String sql = "insert into employee (name, city, phone) values (?,
			// ?, ?)";
			// Connection connection = new getConnection();
			// conn.setAutoCommit(false);
			// PreparedStatement ps = connection.prepareStatement(sql);
			// final int batchSize = 1000;
			// int count = 0;
			// for (Employee employee: employees) {
			// ps.setString(1, employee.getName());
			// ps.setString(2, employee.getCity());
			// ps.setString(3, employee.getPhone());
			// ps.addBatch();
			// if(++count % batchSize == 0) {
			// ps.executeBatch();
			// }
			// }
			// ps.executeBatch(); // insert remaining records
			// conn.commit();
			// ps.close();
			// connection.close();

			// 倒序释放
			rs.close();
			// cStmt.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			System.out.println("存储finally执行的代码=");
		}
		return conn;
	}

	public static void TestInsert() {
		Connection conn = null;
		PreparedStatement pstm = null;		
		try {

			conn = (Connection) DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO tb_grade_info(student_id,subject_id,grade) VALUES(?,?,?)";
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			Long startTime = System.currentTimeMillis();
			Random rand = new Random();
			int a, b;
			for (int i = 1; i <= 1000; i++) {
				a = rand.nextInt(100);
				b = rand.nextInt(1000);
				pstm.setInt(1, a);
				pstm.setInt(2, b);
				pstm.setDouble(3, 14.1);
				pstm.executeUpdate();
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("OK,用时：" + (endTime - startTime)+"毫秒");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}

}
