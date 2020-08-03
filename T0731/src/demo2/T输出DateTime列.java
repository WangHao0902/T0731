package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class T���DateTime�� {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			String sql = "select id, username,password,regtime from admin";
			//Ԥ����
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");

			while(rs.next()){
				int id=rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Timestamp ts = rs.getTimestamp("regtime");
				System.out.println(sdf.format(ts));
			} 
			//6.�ر�����,�ͷ���Դ
			rs.close();	 //�ȹرս��������
			pstmt.close();//�ٹر�ִ�ж���
			conn.close();//�ٹر����ݿ�����
			
		} catch (Exception e) {	//�Ҳ����ļ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
