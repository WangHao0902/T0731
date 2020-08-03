package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class T与数据库的操作 {

	public static void main(String[] args) {
		// 数据库操作	MySQL数据库	数据库名：admin  	字段：id（主键），username，password	
//		mysql
//		driver="com.mysql.jdbc.Driver"
//		url="jdbc:mysql://localhost/数据库名?[后接参数]"
		//数据库的增删改操作
		try {
			//1.加载数据库驱动
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.创建数据库连接
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//3.创建数据库执行对象
			Statement stmt = conn.createStatement();
			//4.执行SQL语句（数据库操作）（查询，更新，增加，删除）
//			String sql = "insert into admin(username,password) values('WangH','1184823900')"; //增
			String sql = "update admin set password = 'abcd' where id = 3";		//更新
			
			stmt.executeUpdate(sql);	//增删改的操作都用这个executeupdate语句
			//5.处理结果集（专门针对查询来说的）
			
			//6.关闭连接,释放资源
			stmt.close();//先关闭执行对象
			conn.close();//再关闭数据库连接
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
