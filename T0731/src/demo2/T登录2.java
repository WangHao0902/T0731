package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class T登录2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入用户名:");
		String uname = sc.next();
		System.out.print("请输入密码:");
		String pass = sc.next();
		sc.close();
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			String sql = "select id, username,password from admin where username =? and password =? ";
			//预编译
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();

				if(rs.next()){
					System.out.println("登录成功");
				}else{
					System.out.println("登录失败");
				}

			//6.关闭连接,释放资源
			rs.close();	 //先关闭结果集对象
			pstmt.close();//再关闭执行对象
			conn.close();//再关闭数据库连接
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
