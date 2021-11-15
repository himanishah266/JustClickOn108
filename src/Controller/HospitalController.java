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

import VO.AmbulanceVO;
import VO.AreaVO;
import VO.CityVO;
import VO.HospitalVO;
import VO.StateVO;
import DAO.AmbulanceDAO;
import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.HospitalDAO;
import DAO.StateDAO;

/**
 * Servlet implementation class HospitalController
 */
@WebServlet("/HospitalController")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String flag=request.getParameter("flag");
	if(flag.equals("loadarea1"))
	{
		loadarea1(request,response);
		
	}
	else if(flag.equals("search"))
	{
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
	else if(flag.equals("loadAreaAjax"))
	{
		loadAreaAjax(request,response);
	}
	}
	private void loadAreaAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
	
		
		int cid=Integer.parseInt(request.getParameter("cityID"));
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		HospitalDAO hdao=new HospitalDAO();
		ls=hdao.loadArea(cityvo);
		
		HttpSession session=request.getSession();
		session.setAttribute("arealist", ls);
	
		response.sendRedirect("admin/loadArea.jsp");
		
		
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int hid=Integer.parseInt(request.getParameter("hospitalID"));
		
		HospitalVO hvo=new HospitalVO();
		hvo.setHospitalID(hid);
		
		HospitalDAO hdao=new HospitalDAO();
		hdao.deleteHospital(hvo);
		
		search(request,response);
		
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int hid=Integer.parseInt(request.getParameter("hospitalID"));
		
		List editlist=new ArrayList();
		
		
		HospitalVO hvo=new HospitalVO();
		hvo.setHospitalID(hid);
		
		HospitalDAO hdao=new HospitalDAO();
		editlist=hdao.editHospital(hvo);
		
		List slist=new ArrayList();
		StateVO statevo=new StateVO();
		StateDAO statedao=new StateDAO();
		slist=statedao.search(statevo);
		
		List clist=new ArrayList();
		CityVO cityvo=new CityVO();
		CityDAO citydao=new CityDAO();
		clist=citydao.searchCity(cityvo);
		
		List arealist=new ArrayList();
		AreaVO areavo=new AreaVO();
		AreaDAO areadao=new AreaDAO();
		arealist=areadao.searchArea(areavo);
		
		HttpSession session=request.getSession();
		session.setAttribute("editlist", editlist);
		session.setAttribute("statelist", slist);
		session.setAttribute("citylist",clist);
		session.setAttribute("arealist",arealist);
		
		response.sendRedirect("admin/editHospital.jsp");
		 
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// TODO Auto-generated method stub
List searchlist=new ArrayList();
		
		HospitalVO hvo=new HospitalVO();
		HospitalDAO hdao=new HospitalDAO();
	
		
		searchlist=hdao.searchHospital(hvo);
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist",searchlist);
		
		response.sendRedirect("admin/viewHospital.jsp");
		
	}

	private void loadarea1(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List statelist=new ArrayList();
		List citylist=new ArrayList();
		List arealist=new ArrayList();
		
		StateVO statevo=new StateVO();
		CityVO cityvo=new CityVO();			
		AreaVO areavo=new AreaVO();
		
		StateDAO statedao=new StateDAO();
		CityDAO citydao=new CityDAO();
		AreaDAO areadao=new AreaDAO();

		
		statelist=statedao.search(statevo);
	     citylist=citydao.searchCity(cityvo);
		  arealist=areadao.searchArea(areavo);
	     
		HttpSession session=request.getSession();
		session.setAttribute("statelist", statelist);
		session.setAttribute("citylist",citylist);
		session.setAttribute("arealist",arealist);
		System.out.println("=====================List" + arealist.size());


		response.sendRedirect("admin/addHospital.jsp");
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
		if(flag.equals("update"))
		{
			update(request,response);
			
			
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String hname=request.getParameter("hospitalName");
		int hid=Integer.parseInt(request.getParameter("hospitalID"));
		String hdes=request.getParameter("hospitalDes");
		
		String cn=request.getParameter("contactNo");
		float latitude=Float.parseFloat(request.getParameter("latitude"));
		float longitude=Float.parseFloat(request.getParameter("longitude"));

		
		int aid=Integer.parseInt(request.getParameter("areaID"));
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int sid=Integer.parseInt(request.getParameter("stateID"));
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		
		
		HospitalVO hvo=new HospitalVO();
		hvo.setHospitalID(hid);
		hvo.setAreavo(areavo);
		hvo.setCityvo(cityvo);
		hvo.setStatevo(statevo);
		hvo.setDeleteStatus("active");
		hvo.setHospitalName(hname);
		hvo.setHospitalDes(hdes);
		hvo.setLatitude(latitude);
		hvo.setLongitude(longitude);
		hvo.setContactNo(cn);
		

		HospitalDAO hdao=new HospitalDAO();
		hdao.updateHospital(hvo);
		
		search(request,response);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String hname=request.getParameter("hn");
		String hdes=request.getParameter("hd");
		
		int sid=Integer.parseInt(request.getParameter("stateID"));
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int aid=Integer.parseInt(request.getParameter("areaID"));
		String cn=request.getParameter("contactNo");
		float latitude=Float.parseFloat(request.getParameter("latitude"));
		float longitude=Float.parseFloat(request.getParameter("longitude"));
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		HospitalVO hvo=new HospitalVO();
		hvo.setAreavo(areavo);
		hvo.setCityvo(cityvo);
		hvo.setStatevo(statevo);
		hvo.setHospitalName(hname);
		hvo.setHospitalDes(hdes);
		hvo.setDeleteStatus("active");
		hvo.setLatitude(latitude);
		hvo.setLongitude(longitude);
		hvo.setContactNo(cn);
		
		
		HospitalDAO hdao=new HospitalDAO();
		hdao.insertHospital(hvo);
		
		
		response.sendRedirect("admin/addHospital.jsp");
		
	}

}
