package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import entity.Message;
import entity.User;

/**
 * Servlet implementation class MessageAddServlet
 */
@WebServlet("/MessageAddServlet")
public class MessageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");    //跳转到用户登录界面
		if(user==null) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
			return;
		}
		//获得留言的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String content=request.getParameter("content");          //留言内容
		Message message=new Message(content,sdf.format(new Date()),user);
		MessageDao md=new MessageDao();     //创建MessageDao对象
		int count=md.addMessage(message);     //调用添加留言的方法
		if(count==1) {        //如果留言成功，跳转到留言列表页面
		         request.getRequestDispatcher("MessageServlet").forward(request,response);    
		} else{  //如果留言失败，提示留言失败
			out.println("<script>alert('留言失败!!');</script>");
		}
		HttpSession sessions=request.getSession();
		MessageDao mds=new MessageDao();   
		List<Message> eml=mds.meList();
		sessions.setAttribute("meList",eml);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
