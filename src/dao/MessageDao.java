package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entity.Message;
import entity.User;

public class  MessageDao {
	Connection connect=null;
	PreparedStatement pre=null;
	ResultSet res=null;
   public int addMessage(Message message){
	   int i=0;
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/lakers","root","kang980628");
		   String sql="insert into message_info(user_id,message_content,message_time) values(?,?,?)";
		   pre=(PreparedStatement) connect.prepareStatement(sql);     //准备插入语句
		   pre.setInt(1, message.getUser().getUser_id());    //为插入语句中的参数赋值
		   pre.setString(2,message.getMessage_content());    
		   pre.setString(3,message.getMessage_time());
		   i=pre.executeUpdate();
		   
	   } catch(Exception e){
		   e.printStackTrace();
	   }
	   return i;
   }
   //得到消息的集合
   public List<Message> meList(){
	   List<Message> meList=new ArrayList<Message>();   //创建集合来存储Message实体类
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lakers","root","kang980628");
		   //查询message_info表和user_info表的信息
		   String sql="select *from message_info,user_info where message_info.user_id=user_info.user_id";
		   pre=(PreparedStatement) connect.prepareStatement(sql);     //准备查询语句
		   res=pre.executeQuery();     //执行查询语句
		   while(res.next()){
			   Message message=new Message(sql, sql, null);
			   message.setMessage_content(res.getString("message_content"));
			   message.SetMessage_id(res.getInt("message_id"));
			   message.setMessage_time(res.getString("message_time"));
			   User user=new User();  //将读取到的消息封装到User实体类中         
			   user.setUser_account(res.getString("user_account"));
			   user.setUser_id(res.getInt("user_id"));
			   user.setUser_pwd(res.getString("user_pwd"));
			   message.setUser(user);
			   meList.add(message);    //将Message类添加到集合中 
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
		   return meList;
   }
	   
}
