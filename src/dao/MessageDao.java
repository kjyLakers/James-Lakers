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
		   pre=(PreparedStatement) connect.prepareStatement(sql);     //׼���������
		   pre.setInt(1, message.getUser().getUser_id());    //Ϊ��������еĲ�����ֵ
		   pre.setString(2,message.getMessage_content());    
		   pre.setString(3,message.getMessage_time());
		   i=pre.executeUpdate();
		   
	   } catch(Exception e){
		   e.printStackTrace();
	   }
	   return i;
   }
   //�õ���Ϣ�ļ���
   public List<Message> meList(){
	   List<Message> meList=new ArrayList<Message>();   //�����������洢Messageʵ����
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lakers","root","kang980628");
		   //��ѯmessage_info���user_info�����Ϣ
		   String sql="select *from message_info,user_info where message_info.user_id=user_info.user_id";
		   pre=(PreparedStatement) connect.prepareStatement(sql);     //׼����ѯ���
		   res=pre.executeQuery();     //ִ�в�ѯ���
		   while(res.next()){
			   Message message=new Message(sql, sql, null);
			   message.setMessage_content(res.getString("message_content"));
			   message.SetMessage_id(res.getInt("message_id"));
			   message.setMessage_time(res.getString("message_time"));
			   User user=new User();  //����ȡ������Ϣ��װ��Userʵ������         
			   user.setUser_account(res.getString("user_account"));
			   user.setUser_id(res.getInt("user_id"));
			   user.setUser_pwd(res.getString("user_pwd"));
			   message.setUser(user);
			   meList.add(message);    //��Message����ӵ������� 
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
		   return meList;
   }
	   
}
