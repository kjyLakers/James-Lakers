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
    
    //根据用户名和密码来查询用户信息
    public User getUser(String account,String pwd){
    	User user=new User();
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		connect=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/lakers","root","kang980628");
    		String sql="select * from user_info where user_account=?and user_pwd=?";
    		pre=(PreparedStatement) connect.prepareStatement(sql);   //准备查询语句
    		pre.setNString(1, account);       //为用户名参数赋值
    		pre.setNString(2,pwd);            //为密码参数赋值
    		res=pre.executeQuery();          //执行查询，返回结果集
    		while(res.next()) {              //读取集合中的信息，并封装到User实体类中
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
