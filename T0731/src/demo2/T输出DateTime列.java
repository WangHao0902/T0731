package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class T输出DateTime列 {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			String sql = "select id, username,password,regtime from admin";
			//预编译
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

			while(rs.next()){
				int id=rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Timestamp ts = rs.getTimestamp("regtime");
				System.out.println(sdf.format(ts));
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
