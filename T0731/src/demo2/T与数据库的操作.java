package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class T�����ݿ�Ĳ��� {

	public static void main(String[] args) {
		// ���ݿ����	MySQL���ݿ�	���ݿ�����admin  	�ֶΣ�id����������username��password	
//		mysql
//		driver="com.mysql.jdbc.Driver"
//		url="jdbc:mysql://localhost/���ݿ���?[��Ӳ���]"
		//���ݿ����ɾ�Ĳ���
		try {
			//1.�������ݿ�����
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.�������ݿ�����
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//3.�������ݿ�ִ�ж���
			Statement stmt = conn.createStatement();
			//4.ִ��SQL��䣨���ݿ����������ѯ�����£����ӣ�ɾ����
//			String sql = "insert into admin(username,password) values('WangH','1184823900')"; //��
			String sql = "update admin set password = 'abcd' where id = 3";		//����
			
			stmt.executeUpdate(sql);	//��ɾ�ĵĲ����������executeupdate���
			//5.����������ר����Բ�ѯ��˵�ģ�
			
			//6.�ر�����,�ͷ���Դ
			stmt.close();//�ȹر�ִ�ж���
			conn.close();//�ٹر����ݿ�����
			
		} catch (Exception e) {	//�Ҳ����ļ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
