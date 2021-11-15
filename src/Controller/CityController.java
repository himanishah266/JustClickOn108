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

import DAO.CityDAO;
import DAO.StateDAO;
import VO.CityVO;
import VO.StateVO;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("loadstate"))
		{
			try {
				loadstate(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("search"))
		{
			System.out.println("search");
			search(request,response);
		}
		else if(flag.equals("edit"))
				{
			        edit(request,response);
				}
		else if(flag.equals("delete"))
		{
			delete(request,response);
		}
			
		}
		
		
	

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id1=Integer.parseInt(request.getParameter("cityID"));
		CityVO cityvo=new CityVO();
		cityvo.setCityID(id1);
		
		CityDAO citydao=new CityDAO();
		citydao.deleteCity(cityvo);
		
		search(request,response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
	
		int id=Integer.parseInt(request.getParameter("cityID"));
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(id);
		
		CityDAO citydao=new CityDAO();
		ls=citydao.editCity(cityvo);
		
		StateVO statevo=new StateVO();
		StateDAO statedao=new StateDAO();
		List ls1=new ArrayList();
		
		ls1=statedao.search(statevo);
		
		HttpSession session=request.getSession();
		session.setAttribute("editlist", ls);
		session.setAttribute("list1", ls1);

		response.sendRedirect("admin/editCity.jsp");
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		
		CityVO cityvo=new CityVO();
		CityDAO dao=new CityDAO();
		ls=dao.searchCity(cityvo);
		System.out.println("=====================List" + ls.size());
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist", ls);
		
		response.sendRedirect("admin/viewCity.jsp");
		
	}

	private void loadstate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/*List ls=new ArrayList();
		
		StateVO statevo=new StateVO();
		
		CityDAO citydao=new CityDAO();
		
	    ls=citydao.loadstate(statevo);
		HttpSession session=request.getSession();
		session.setAttribute("list", ls);
		*/
		List ls=new ArrayList();
		StateVO statevo=new StateVO();
		
		StateDAO dao=new StateDAO();
		
		ls=dao.search(statevo);
		HttpSession session=request.getSession();
		session.setAttribute("list", ls);
		response.sendRedirect("admin/addCity.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{
			try {
				insert(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag.equals("update"))
		{
			try {
				update(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(request.getParameter("cityID"));
		String n=request.getParameter("cityName");
		
		int sid=Integer.parseInt(request.getParameter("stateID"));
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		
		CityVO cityvo=new CityVO();
		
		cityvo.setCityID(id);
		cityvo.setCityName(n);
		cityvo.setStatevo(statevo);
		
		cityvo.setDeleteStatus("active");
		
		CityDAO citydao=new CityDAO();
		citydao.update(cityvo);
		
		search(request,response);
	
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		int id=Integer.parseInt(request.getParameter("stateID"));
		String cname=request.getParameter("cityName");
		
		StateVO statevo=new StateVO();
		statevo.setStateID(id);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityName(cname);
		
		cityvo.setStatevo(statevo);
		cityvo.setDeleteStatus("active");
		
		CityDAO citydao=new CityDAO();
		citydao.insertCity(cityvo);
		
		response.sendRedirect("admin/addCity.jsp");
		
	}

}
