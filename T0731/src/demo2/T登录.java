package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class T登录 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入用户名:");
		String uname = sc.next();
		System.out.print("请输入密码:");
		String pass = sc.next();
		sc.close();
		
		// 数据库操作	MySQL数据库	数据库名：admin  	字段：id（主键），username，password	
//		mysql
//		driver="com.mysql.jdbc.Driver"
//		url="jdbc:mysql://localhost/数据库名?[后接参数]"
		//数据库的查找操作
		try {
			//1.加载数据库驱动
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.创建数据库连接
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//3.创建数据库执行对象
			Statement stmt = conn.createStatement();
			//4.执行SQL语句（数据库操作）（查询，更新，增加，删除）
			String sql = "select id, username,password from admin where username = '" + uname + "' and password = '" + pass + "'" ;
			ResultSet rs = stmt.executeQuery(sql);//查询专用：executeQuery()，查询有结果，所以用ResultSet方法
//			stmt.executeUpdate(sql);	//增删改的操作都用这个executeupdate语句
			//5.处理结果集（专门针对查询来说的）
//				while(rs.next()){
//					int id = rs.getInt("id");
//					String username = rs.getString("username");
//					String password = rs.getString("password");
//					if(username.equals(uname)){
//						if(password.equals(pass)){
//							System.out.println("登录成功");
//							break;
//						}else{
//							System.out.println("密码错误");
//						}
//					}
//				}
				if(rs.next()){
					System.out.println("登录成功");
				}else{
					System.out.println("登录失败");
				}

			//6.关闭连接,释放资源
			rs.close();	 //先关闭结果集对象
			stmt.close();//再关闭执行对象
			conn.close();//再关闭数据库连接
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
