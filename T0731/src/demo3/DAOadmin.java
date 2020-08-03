package demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DAOadmin extends BaseDAO{
	
	public DAOadmin(){
		
	}
	
	public void insert(String username,String password,Timestamp ts){
		PreparedStatement pstmt = null;
		try {
			
			String sql = "insert into admin(username,password,regtime) values(?,?,?)";
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("增加成功");
			}
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null, pstmt, null);
		}
	}
	
	
	public void update(String username,int id){
		PreparedStatement pstmt = null;
		try {
			
			String sql = "update admin set username=? where id = ? ";
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, id);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("修改成功");
			}
			
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null, pstmt, null);
		}
	}
	
	public void select(String username,String password){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String sql = "select id, username,password,regtime from admin where username=? and password=?";
			pstmt = getConn().prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if(rs.next()){
				System.out.println("查找成功");
			}else{
				System.out.println("查找失败");
			}
		} catch (Exception e) {	//找不到文件的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null, pstmt, rs);
		}
	}
	
	public void delete(){
		
	}
	
}
