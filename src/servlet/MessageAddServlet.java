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
		User user=(User) session.getAttribute("user");    //��ת���û���¼����
		if(user==null) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
			return;
		}
		//������Ե�ʱ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String content=request.getParameter("content");          //��������
		Message message=new Message(content,sdf.format(new Date()),user);
		MessageDao md=new MessageDao();     //����MessageDao����
		int count=md.addMessage(message);     //����������Եķ���
		if(count==1) {        //������Գɹ�����ת�������б�ҳ��
		         request.getRequestDispatcher("MessageServlet").forward(request,response);    
		} else{  //�������ʧ�ܣ���ʾ����ʧ��
			out.println("<script>alert('����ʧ��!!');</script>");
		}
		HttpSession sessions=request.getSession();
		MessageDao mds=new MessageDao();   
		List<Message> eml=mds.meList();
		sessions.setAttribute("meList",eml);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
