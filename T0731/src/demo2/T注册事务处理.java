package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;


public class Tע�������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ע���û���:");
		String uname = sc.next();
		System.out.print("����������:");
		String pass = sc.next();
		sc.close();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		try {
			//1.�������ݿ�����
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.�������ݿ�����
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//�ر�commit���Զ��ύ
			conn.setAutoCommit(false);
			//3.�������ݿ�ִ�ж���
			Statement stmt = conn.createStatement();
			//4.ִ��SQL��䣨���ݿ����������ѯ�����£����ӣ�ɾ����
			String sql = "insert into admin(username,password,regtime) values(?,?,?)"; //��
//			String sql = "update admin set password = 'abcd' where id = 3";		//����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("ע��ɹ�");
			}
			//������
			conn.commit();
//			conn.rollback();
			
			
			//6.�ر�����,�ͷ���Դ
			pstmt.close();//�ȹر�ִ�ж���
			conn.close();//�ٹر����ݿ�����
			
		} catch (Exception e) {	//�Ҳ����ļ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
