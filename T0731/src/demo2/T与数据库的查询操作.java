package demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class T�����ݿ�Ĳ�ѯ���� {

	public static void main(String[] args) {
		// ���ݿ����	MySQL���ݿ�	���ݿ�����admin  	�ֶΣ�id����������username��password	
//		mysql
//		driver="com.mysql.jdbc.Driver"
//		url="jdbc:mysql://localhost/���ݿ���?[��Ӳ���]"
		//���ݿ�Ĳ��Ҳ���
		try {
			//1.�������ݿ�����
			Class.forName("org.gjt.mm.mysql.Driver");
			//2.�������ݿ�����
//			String url="jbdc:mysql://localhost/test";
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "1234");
			//3.�������ݿ�ִ�ж���
			Statement stmt = conn.createStatement();
			//4.ִ��SQL��䣨���ݿ����������ѯ�����£����ӣ�ɾ����
			String sql = "select id, username,password from admin;";
			ResultSet rs = stmt.executeQuery(sql);//��ѯר�ã�executeQuery()����ѯ�н����������ResultSet����
//			stmt.executeUpdate(sql);	//��ɾ�ĵĲ����������executeupdate���
			//5.����������ר����Բ�ѯ��˵�ģ�
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println("id:" + id + ";	username:" + username + ";	password:" + password);
			}
			//6.�ر�����,�ͷ���Դ
			rs.close();	 //�ȹرս��������
			stmt.close();//�ٹر�ִ�ж���
			conn.close();//�ٹر����ݿ�����
			
		} catch (Exception e) {	//�Ҳ����ļ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
