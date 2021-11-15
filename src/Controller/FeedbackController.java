package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ComplaintDAO;
import DAO.FeedbackDAO;
import VO.ComplaintVO;
import VO.FeedbackVO;
import VO.LoginVO;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("searchFeedback"))
		{
			searchFeedback(request,response);
		}
	}

	private void searchFeedback(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
List searchlist=new ArrayList();
		
		FeedbackVO feedbackvo=new FeedbackVO();
		FeedbackDAO feedbackdao=new FeedbackDAO();
	
		searchlist=feedbackdao.searchFeedback();
		
		HttpSession session=request.getSession();
		session.setAttribute("searchfeedback",searchlist);
		
		response.sendRedirect("admin/viewFeedback.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("insertFeedback"))
		{
			insertFeedback(request,response);
		}
	}

	private void insertFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		int id=(int) request.getSession().getAttribute("userID");

		LoginVO loginvo=new LoginVO();
		loginvo.setLoginID(id);
		
		Date d=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String feedbackDate = dateFormat.format(d);
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String feedbackTime = timeFormat.format(d);

		System.out.println(feedbackTime);

		
		FeedbackVO feedbackvo=new FeedbackVO();
		feedbackvo.setMessage(message);
		feedbackvo.setSubject(subject);
		feedbackvo.setFeedbackFrom(loginvo);
		feedbackvo.setFeedbackDate(feedbackDate);
		feedbackvo.setFeedbackTime(feedbackTime);
		
		FeedbackDAO feedbackdao=new FeedbackDAO();
		feedbackdao.insert(feedbackvo);
		
		try {
			response.sendRedirect("user/feedback.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
