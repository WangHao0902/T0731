package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;


public class T注册事务处理 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入注册用户名:");
		String uname = sc.next();
		System.out.print("请输入密码:");
		String pass = sc.next();
		sc.close();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		try {
			//1.加载数据库驱动
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.创建数据库连接
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//关闭commit的自动提交
			conn.setAutoCommit(false);
			//3.创建数据库执行对象
			Statement stmt = conn.createStatement();
			//4.执行SQL语句（数据库操作）（查询，更新，增加，删除）
			String sql = "insert into admin(username,password,regtime) values(?,?,?)"; //增
//			String sql = "update admin set password = 'abcd' where id = 3";		//更新
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("注册成功");
			}
			//事务处理
			conn.commit();
//			conn.rollback();
			
			
			//6.关闭连接,释放资源
			pstmt.close();//先关闭执行对象
			conn.close();//再关闭数据库连接
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
