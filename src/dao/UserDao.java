package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;

import entity.User;

import com.mysql.jdbc.Connection;

public class UserDao {
    Connection connect=null;
    PreparedStatement pre=null;
    ResultSet res=null;  
    
    //�����û�������������ѯ�û���Ϣ
    public User getUser(String account,String pwd){
    	User user=new User();
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		connect=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/lakers","root","kang980628");
    		String sql="select * from user_info where user_account=?and user_pwd=?";
    		pre=(PreparedStatement) connect.prepareStatement(sql);   //׼����ѯ���
    		pre.setNString(1, account);       //Ϊ�û���������ֵ
    		pre.setNString(2,pwd);            //Ϊ���������ֵ
    		res=pre.executeQuery();          //ִ�в�ѯ�����ؽ����
    		while(res.next()) {              //��ȡ�����е���Ϣ������װ��Userʵ������
    			user.setUser_account(res.getString("user_account"));
    			user.setUser_id(res.getInt("user_id"));
    			user.setUser_pwd(res.getString("user_pwd"));
    			
    		}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
      	}
    	return user;
    }
}
