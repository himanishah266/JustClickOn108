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
import DAO.HospitalDAO;
import DAO.RegisterDAO;
import VO.ComplaintVO;
import VO.HospitalVO;
import VO.LoginVO;

/**
 * Servlet implementation class ComplaintController
 */
@WebServlet("/ComplaintController")
public class ComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("searchComplaint"))
		{
			searchComplaint(request,response);
		}
		if(flag.equals("editComplaint"))
		{
			reply(request,response);
		}
	}

	private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		List ls = new ArrayList();
		
		int i1 = Integer.parseInt(request.getParameter("cid"));

		ComplaintVO complaintvo=new ComplaintVO();
		complaintvo.setCid(i1);
		

		ComplaintDAO complaintdao = new ComplaintDAO();
		ls = complaintdao.replyComplaint(complaintvo);

		HttpSession session = request.getSession();
		session.setAttribute("replylist", ls);
		
		response.sendRedirect("admin/reply.jsp");
		
	}

	private void searchComplaint(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
List searchlist=new ArrayList();
		
		ComplaintVO complaintvo=new ComplaintVO();
		ComplaintDAO cdao=new ComplaintDAO();
	
		searchlist=cdao.searchComplaint();
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist",searchlist);
		
		response.sendRedirect("admin/viewComplaint.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("complaint"))
		{
			insertComplaint(request,response);
			
		}
		if(flag.equals("updateComplaint"))
		{
			updateComplaint(request,response);
			
		}
	}

	private void updateComplaint(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int complaintFrom=Integer.parseInt(request.getParameter("complaintFrom"));
		
		LoginVO loginvo=new LoginVO();
		loginvo.setLoginID(complaintFrom);

		
		String ctitle= request.getParameter("ctitle");
		String cdesc=request.getParameter("cdesc");
		String creply=request.getParameter("creply");
		int complaintID =Integer.parseInt(request.getParameter("cid"));
		
		
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(d);
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String time = timeFormat.format(d);
		
		ComplaintVO complaintvo=new ComplaintVO();
		complaintvo.setCid(complaintID);
		complaintvo.setComplaintDate(date);
		complaintvo.setComplaintTime(time);
		complaintvo.setCtitle(ctitle);
		complaintvo.setCdesc(cdesc);
		complaintvo.setCreply(creply);
		complaintvo.setComplaintFrom(loginvo);
		complaintvo.setComplaintStatus("received");
		
		ComplaintDAO complaintdao=new ComplaintDAO();
		complaintdao.sendResponse(complaintvo);
		
		searchComplaint(request,response);
		
		
		
		
		
		
		
		
		
	}

	private void insertComplaint(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String ctitle=request.getParameter("ctitle");
		String cdesc=request.getParameter("cdesc");
		int id=(int) request.getSession().getAttribute("userID");
		
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(d);
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String time = timeFormat.format(d);

		System.out.println(time);
		
		LoginVO complaintFrom=new LoginVO();
		complaintFrom.setLoginID(id);
		
		RegisterDAO dao=new RegisterDAO();
		List<LoginVO> ls=dao.searchAdmin();
		
		LoginVO complaintTo=new LoginVO();
		complaintTo.setLoginID(ls.get(0).getLoginID());
		
		
		ComplaintVO complaintvo=new ComplaintVO();
		
		complaintvo.setCdesc(cdesc);
		complaintvo.setCtitle(ctitle);
		complaintvo.setComplaintDate(date);
		complaintvo.setComplaintTime(time);
		complaintvo.setComplaintFrom(complaintFrom);
		complaintvo.setComplaintTo(complaintTo);
		complaintvo.setComplaintStatus("pending");
		
		ComplaintDAO complaintdao = new ComplaintDAO();
		complaintdao.insert(complaintvo);

		response.sendRedirect("user/complaint.jsp");
	
		
	}

}
