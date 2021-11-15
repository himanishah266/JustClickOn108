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
import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.RegisterDAO;
import DAO.StaffDAO;
import DAO.StateDAO;
import VO.AmbulanceVO;
import VO.AreaVO;
import VO.CityVO;
import VO.LoginVO;
import VO.StaffVO;
import VO.StateVO;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("loadAmbulance"))
		{
			loadAmbulance(request,response);
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
		else if(flag.equals("loadAmbulanceAjax"))
		{
			loadAmbulanceAjax(request,response);

		}
		
	}

	private void loadAmbulanceAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
List ls=new ArrayList();
	
		
		int areaid1=Integer.parseInt(request.getParameter("areaID"));
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(areaid1);
		
		
		StaffDAO sdao=new StaffDAO();
		ls=sdao.loadAmbulance(areavo);
		
		HttpSession session=request.getSession();
		session.setAttribute("ambulancelist", ls);
	
		response.sendRedirect("admin/loadAmbulance.jsp");
		
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
int sno=Integer.parseInt(request.getParameter("serialNo"));
		
		StaffVO svo=new StaffVO();
		svo.setSerialNo(sno);
		
		StaffDAO sdao=new StaffDAO();
		sdao.deleteStaff(svo);
		search(request,response);
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		List slist=new ArrayList();
		StateVO statevo=new StateVO();
		StateDAO statedao=new StateDAO();
		slist=statedao.search(statevo);
		
		List clist=new ArrayList();
		CityVO cityvo=new CityVO();
		CityDAO citydao=new CityDAO();
		clist=citydao.searchCity(cityvo);
		
		List arlist=new ArrayList();
		AreaVO areavo=new AreaVO();
		AreaDAO areadao=new AreaDAO();
		arlist=areadao.searchArea(areavo);
		
		List alist=new ArrayList();
		AmbulanceVO avo=new AmbulanceVO();
		AmbulanceDAO adao=new AmbulanceDAO();
		alist=adao.searchAmbulance(avo);
		
		int sno=Integer.parseInt(request.getParameter("serialNo"));
		List editlist=new ArrayList();
		
		StaffVO svo=new StaffVO();
		svo.setSerialNo(sno);
		
		StaffDAO sdao=new StaffDAO();
		editlist=sdao.editStaff(svo);
		
		HttpSession session=request.getSession();
		session.setAttribute("editlist", editlist);
		session.setAttribute("statelist", slist);
		session.setAttribute("citylist",clist);
		session.setAttribute("arealist",arlist);
		session.setAttribute("ambulancelist",alist);

		
		response.sendRedirect("admin/editStaff.jsp");
		
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		List searchlist=new ArrayList();
		
		StaffVO svo=new StaffVO();
		StaffDAO sdao=new StaffDAO();
		
		searchlist=sdao.searchStaff(svo);
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist", searchlist);
		
		
		response.sendRedirect("admin/viewStaff.jsp");
		
		
		
	}

	private void loadAmbulance(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		List statelist=new ArrayList();
		List citylist=new ArrayList();
		List arealist=new ArrayList();
		List ablist=new ArrayList();
		
		StateVO statevo=new StateVO();
		CityVO cityvo=new CityVO();			
		AreaVO areavo=new AreaVO();
		AmbulanceVO avo=new AmbulanceVO();
		
		StateDAO statedao=new StateDAO();
		CityDAO citydao=new CityDAO();
		AreaDAO areadao=new AreaDAO();
		AmbulanceDAO adao=new AmbulanceDAO();

		
		statelist=statedao.search(statevo);
	     citylist=citydao.searchCity(cityvo);
		  arealist=areadao.searchArea(areavo);
		  ablist=adao.searchAmbulance(avo);
	     
		HttpSession session=request.getSession();
		session.setAttribute("statelist", statelist);
		session.setAttribute("citylist",citylist);
		session.setAttribute("arealist",arealist);
		session.setAttribute("ablist",ablist);


		
		response.sendRedirect("admin/addStaff.jsp");
		
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
			loadAmbulance(request,response);

		}
		else if(flag.equals("update"))
		{
			update(request,response);

			search(request,response);
			
			
		}
			
			
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		
		int ano=Integer.parseInt(request.getParameter("ambulanceNumber"));
		int aid=Integer.parseInt(request.getParameter("areaID"));
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int sid=Integer.parseInt(request.getParameter("stateID"));
		int sno=Integer.parseInt(request.getParameter("serialNo"));
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setAmbulanceNumber(ano);
		
		
		String emailID=request.getParameter("emailID");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String birthDate=request.getParameter("birthDate");
		String contactNo=request.getParameter("contactNo");
		String gender=request.getParameter("gender");
		String post=request.getParameter("post");
		
		StaffVO svo=new StaffVO();
		svo.setSerialNo(sno);
		svo.setAreavo(areavo);
		svo.setCityvo(cityvo);
		svo.setStatevo(statevo);
		svo.setAvo(avo);
		svo.setBirthDate(birthDate);
		svo.setContactNo(contactNo);
		svo.setFirstName(firstName);
		svo.setLastName(lastName);
		svo.setGender(gender);
		svo.setPost(post);
		svo.setDeleteStatus("active");
		
		
		StaffDAO sdao=new StaffDAO();
		sdao.updateStaff(svo);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.err.println("=====----------------------=");
		int sid=Integer.parseInt(request.getParameter("stateID"));
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int aid=Integer.parseInt(request.getParameter("areaID"));
        int ano=Integer.parseInt(request.getParameter("ambulanceNumber"));
        
		int idd=(int) request.getSession().getAttribute("userID");
		
		System.err.println("+++++++++++++++"+idd);
		
		
		/*LoginVO loginvo=new LoginVO();
		loginvo.setLoginID(idd);
        */

		
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setAmbulanceNumber(ano);
		
		String emailID=request.getParameter("emailID");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String birthDate=request.getParameter("birthDate");
		String contactNo=request.getParameter("contactNo");
		String gender=request.getParameter("gender");
		String post=request.getParameter("post");
		String password=request.getParameter("password");

		
		LoginVO loginvo=new LoginVO();
		loginvo.setUserName(emailID);
		loginvo.setPassword(password);
		loginvo.setUserType(post);
		
		RegisterDAO registerdao=new RegisterDAO();
		registerdao.insert(loginvo);

		
		StaffVO svo=new StaffVO();
		svo.setAreavo(areavo);
		svo.setCityvo(cityvo);
		svo.setStatevo(statevo);
		svo.setAvo(avo);
		svo.setBirthDate(birthDate);
		svo.setContactNo(contactNo);
		
		svo.setFirstName(firstName);
		svo.setLastName(lastName);
		svo.setGender(gender);
		svo.setPost(post);
		svo.setLoginvo(loginvo);
		svo.setDeleteStatus("active");
		
		StaffDAO sdao=new StaffDAO();
		sdao.insertStaff(svo);
	
	}

}