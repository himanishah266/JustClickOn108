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

import VO.AreaVO;
import VO.CityVO;
import VO.StateVO;
import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.StateDAO;

/**
 * Servlet implementation class AreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("loadcity"))
			
		{
			loadcity(request,response);
		}
		else if(flag.equals("search"))
		{
			try {
				search(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("edit"))
		{
			try {
				edit(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("delete"))
		{
			try {
				delete(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("loadCityAjax"))
		{
			loadCityAjax(request,response);
		}
	}

	private void loadCityAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		
		int sid=Integer.parseInt(request.getParameter("stateID"));
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		AreaDAO areadao=new AreaDAO();
		ls=areadao.loadCity(statevo);
		
		HttpSession session=request.getSession();
		session.setAttribute("citylist", ls);
	
		response.sendRedirect("admin/loadCity.jsp");
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int aid=Integer.parseInt(request.getParameter("areaID"));
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		AreaDAO areadao=new AreaDAO();
		areadao.deleteArea(areavo);
		search(request,response);
		
		}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	List editlist=new ArrayList();
	int areaid=Integer.parseInt(request.getParameter("areaID"));
	
	AreaVO areavo=new AreaVO();
	areavo.setAreaID(areaid);
	AreaDAO areadao=new AreaDAO();
	
	editlist=areadao.editArea(areavo);
	
	List slist=new ArrayList();
	StateVO statevo=new StateVO();
	StateDAO statedao=new StateDAO();
	slist=statedao.search(statevo);
	
	List clist=new ArrayList();
	CityVO cityvo=new CityVO();
	CityDAO citydao=new CityDAO();
	clist=citydao.searchCity(cityvo);
	
	HttpSession session=request.getSession();
	session.setAttribute("editlist", editlist);
	session.setAttribute("slist", slist);
	session.setAttribute("clist",clist);


	response.sendRedirect("admin/editArea.jsp");
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	List searchlist=new ArrayList();
			
		AreaVO areavo=new AreaVO();
		AreaDAO areadao=new AreaDAO();
		
		searchlist=areadao.searchArea(areavo);
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist",searchlist);
		
		response.sendRedirect("admin/viewArea.jsp");
		
	}

	private void loadcity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List statelist=new ArrayList();
		List citylist=new ArrayList();
		
		StateVO statevo=new StateVO();
		CityVO cityvo=new CityVO();
		
		StateDAO statedao=new StateDAO();
		CityDAO citydao=new CityDAO();
		
		
		statelist=statedao.search(statevo);
	     citylist=citydao.searchCity(cityvo);
		
	     
		HttpSession session=request.getSession();
		session.setAttribute("statelist", statelist);
		session.setAttribute("citylist",citylist);
		
		response.sendRedirect("admin/addArea.jsp");
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		else if(flag.equals("update"))
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
		
		int id=Integer.parseInt(request.getParameter("areaID"));
		String areaname=request.getParameter("areaName");
		String areades=request.getParameter("areaDes");
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int sid=Integer.parseInt(request.getParameter("stateID"));
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(id);
		areavo.setAreaName(areaname);
		areavo.setAreaDes(areades);
		areavo.setCityvo(cityvo);
		areavo.setStatevo(statevo);
		areavo.setDeleteStatus("active");
		
		AreaDAO areadao=new AreaDAO();
		areadao.updateArea(areavo);
		
		search(request,response);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int ids=Integer.parseInt(request.getParameter("stateID"));
		int idc=Integer.parseInt(request.getParameter("cityID"));
		
		StateVO statevo=new StateVO();
		statevo.setStateID(ids);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(idc);
		
		String areaName=request.getParameter("areaName");
		String areaDes=request.getParameter("areaDes");
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaName(areaName);
		areavo.setAreaDes(areaDes);
		
		areavo.setStatevo(statevo);
		areavo.setCityvo(cityvo);
		areavo.setDeleteStatus("active");
		
		AreaDAO areadao=new AreaDAO();
		areadao.insertArea(areavo);
		response.sendRedirect("admin/addArea.jsp");
	}

}
