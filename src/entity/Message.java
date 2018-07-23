package entity;
import java.io.Serializable;
public class Message implements Serializable{
   private static final long serialVersionUID=1L;
   private int message_id;     //����ID
   private User user;          //���Ӧ�����û���Ϣ
   private String message_content;    //��������
   private String message_time;      //����ʱ��
   public Message(String message_content,String message_time,User user)
   {
	   this.message_content=message_content;
	   this.user=user;
	   this.message_time=message_time;
   }
   public int getInt(){
	   return message_id;
   }
   public void SetMessage_id(int message_id){
	   this.message_id=message_id;
   }
   public User getUser(){
	   return user;
   }
   public void setUser(User user){
	   this.user=user;
   }
   public String getMessage_content(){
	   return message_content;   
   }
   public void setMessage_content(String message_content){
	   this.message_content=message_content;
   }
   public String getMessage_time(){
	   return message_time;
   }
   public void setMessage_time(String message_time){
	   this.message_time=message_time;
   }
}