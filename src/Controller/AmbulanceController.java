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
import DAO.HospitalDAO;
import DAO.StateDAO;
import VO.AmbulanceVO;
import VO.AreaVO;
import VO.CityVO;
import VO.StateVO;
/**
 * Servlet implementation class AmbulanceController

 */
@WebServlet("/AmbulanceController")
public class AmbulanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmbulanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("loadarea"))
		{
			try {
				loadarea(request,response);
			} catch (Exception e) {
						// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			edit(request,response);
		}
		else if(flag.equals("delete"))
		{
			try {
				delete(request,response);
				search(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
int anum=Integer.parseInt(request.getParameter("ambulanceNumber"));
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setAmbulanceNumber(anum);
		
		AmbulanceDAO adao=new AmbulanceDAO();
		adao.deleteAmbulance(avo);
		
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		List editlist=new ArrayList();
		int ano=Integer.parseInt(request.getParameter("ambulanceNumber"));
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setAmbulanceNumber(ano);
		
		AmbulanceDAO adao=new AmbulanceDAO();
		editlist=adao.editAmbulance(avo);
		
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
		session.setAttribute("slist", slist);
		session.setAttribute("clist",clist);
		session.setAttribute("arealist",arealist);
		
		response.sendRedirect("admin/editAmbulance.jsp");
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		List searchlist=new ArrayList();
		
		AmbulanceVO avo=new AmbulanceVO();
		AmbulanceDAO adao=new AmbulanceDAO();
	
		
		searchlist=adao.searchAmbulance(avo);
		
		HttpSession session=request.getSession();
		session.setAttribute("searchlist",searchlist);
		
		response.sendRedirect("admin/viewAmbulance.jsp");
		
	}

	private void loadarea(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
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
		

		
		response.sendRedirect("admin/addAmbulance.jsp");
		
		
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
		else if(flag.equals("update"))
		{
			try {
				update(request,response);
				search(request,response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int ano=Integer.parseInt(request.getParameter("ambulanceNumber"));
		
		int modelno=Integer.parseInt(request.getParameter("modelNumber"));
		String allocation=request.getParameter("allocation");
		String pyear=request.getParameter("passingYear");
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
		
		
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setAllocation(allocation);
		avo.setModelNumber(modelno);
		avo.setPassingYear(pyear);
		avo.setAmbulanceNumber(ano);
		avo.setStatevo(statevo);
		avo.setCityvo(cityvo);
		avo.setAreavo(areavo);
		avo.setDeleteStatus("active");
		avo.setLatitude(latitude);
        avo.setLongitude(longitude);
        
		AmbulanceDAO adao=new AmbulanceDAO();
		adao.updateAmbulance(avo);
		
		
		
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int sid=Integer.parseInt(request.getParameter("stateID"));
		int cid=Integer.parseInt(request.getParameter("cityID"));
		int aid=Integer.parseInt(request.getParameter("areaID"));
		
		int modelno=Integer.parseInt(request.getParameter("ambulanceNumber"));
		String allocation=request.getParameter("allocation");
		String pyear=request.getParameter("passingYear");
		float latitude=Float.parseFloat(request.getParameter("latitude"));
		float longitude=Float.parseFloat(request.getParameter("longitude"));

		
	
		StateVO statevo=new StateVO();
		statevo.setStateID(sid);
		
		CityVO cityvo=new CityVO();
		cityvo.setCityID(cid);
		
		AreaVO areavo=new AreaVO();
		areavo.setAreaID(aid);
		
		AmbulanceVO avo=new AmbulanceVO();
		avo.setModelNumber(modelno);
		avo.setAllocation(allocation);
		avo.setPassingYear(pyear);
		avo.setStatevo(statevo);
		avo.setCityvo(cityvo);
		avo.setAreavo(areavo);
		avo.setDeleteStatus("active");
		avo.setLatitude(latitude);
		avo.setLongitude(longitude);
		
		
		AmbulanceDAO adao=new AmbulanceDAO();
		adao.insertAmbulance(avo);
		response.sendRedirect("admin/addAmbulance.jsp");
	}

	

}
