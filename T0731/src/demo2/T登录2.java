package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class T��¼2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������û���:");
		String uname = sc.next();
		System.out.print("����������:");
		String pass = sc.next();
		sc.close();
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");

			String sql = "select id, username,password from admin where username =? and password =? ";
			//Ԥ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();

				if(rs.next()){
					System.out.println("��¼�ɹ�");
				}else{
					System.out.println("��¼ʧ��");
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
