package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AmbulanceDAO;
import DAO.LocationDAO;
import VO.AmbulanceVO;
import VO.LocationVO;

/**
 * Servlet implementation class UmapController
 */
@WebServlet("/UmapController")
public class UmapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UmapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String flag=request.getParameter("flag");
		
		 if(flag.equals("search"))
		{
			try {
				search(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		List searchlist=new ArrayList();
		
		AmbulanceVO avo=new AmbulanceVO();
		AmbulanceDAO adao=new AmbulanceDAO();
		searchlist=adao.searchAmbulance(avo);
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist",searchlist);
		
		response.sendRedirect("user/mapuser.jsp");		
	}


}
