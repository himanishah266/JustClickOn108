package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DAO.AmbulanceDAO;
import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.HospitalDAO;
import DAO.LocationDAO;
import DAO.RegisterDAO;
import VO.AmbulanceVO;
import VO.AreaVO;
import VO.CityVO;
import VO.HibernateProxyTypeAdapter;
import VO.HospitalVO;
import VO.LocationVO;
import VO.LoginVO;
import VO.StateVO;

/**
 * Servlet implementation class sendLocationController
 */
@WebServlet("/sendLocationController")
public class sendLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sendLocationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");
		if (flag.equals("searchLocation")) {
			searchLocation(request, response);
		} else if (flag.equals("loadUserAjax")) {
			loadUserAjax(request, response);
		} else if (flag.equals("loadCaseAjax")) {
			loadCaseAjax(request, response);
			System.out.println("llllllllllllllllllll");
		} else if (flag.equals("inLocation")) {
			inLocation(request, response);

		}

	}

	private String inLocation(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		List<AmbulanceVO> Ambulancelist = new ArrayList();

		AmbulanceVO avo = new AmbulanceVO();
		AmbulanceDAO adao = new AmbulanceDAO();
		Ambulancelist = adao.searchAmbulance(avo);

		HttpSession session = request.getSession();
		session.setAttribute("Ambulancelist", Ambulancelist);

		List<LocationVO> Locationlist = new ArrayList();

		LocationVO lvo = new LocationVO();
		LocationDAO ldao = new LocationDAO();

		Locationlist = ldao.inLocation(lvo);

		session.setAttribute("Locationlist", Locationlist);

		List ls = new ArrayList();
		LoginVO loginvo = new LoginVO();
		RegisterDAO logindao = new RegisterDAO();
		ls = logindao.search(loginvo);

		session.setAttribute("loginlist", ls);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("Ambulancelist", Ambulancelist);
		map.put("Locationlist", Locationlist);

		System.err.println("------Ambulancelist--------++++++++++"
				+ Ambulancelist.size() + "++++++--------------------");
		System.err.println("---------Locationlist-----++++++++"
				+ Locationlist.size() + "+++++++--------------------");

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		System.err.println(gson.toJson(map));
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		return "";

	}

	private void loadCaseAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		int lid = Integer.parseInt(request.getParameter("locationID"));

		LocationVO lvo = new LocationVO();
		lvo.setLocationID(lid);

		LocationDAO ldao = new LocationDAO();
		ls = ldao.searchLocation(lvo);

		HttpSession session = request.getSession();
		session.setAttribute("locationlist", ls);

		session.setAttribute("lid", lid);

		System.out.println("lid----------->>>>>>>>>" + lid);

		response.sendRedirect("admin/loadCase.jsp");

	}

	private void loadUserAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		List ls = new ArrayList();

		int lid = Integer.parseInt(request.getParameter("loginID"));

		LoginVO lvo = new LoginVO();
		lvo.setLoginID(lid);

		RegisterDAO rdao = new RegisterDAO();
		ls = rdao.search(lvo);

		HttpSession session = request.getSession();
		session.setAttribute("loginlist", ls);

		response.sendRedirect("admin/loadLoginID.jsp");

	}

	private String searchLocation(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<AmbulanceVO> Ambulancelist = new ArrayList();

		AmbulanceVO avo = new AmbulanceVO();
		AmbulanceDAO adao = new AmbulanceDAO();
		Ambulancelist = adao.searchAmbulance(avo);

		HttpSession session = request.getSession();
		session.setAttribute("Ambulancelist", Ambulancelist);

		List<LocationVO> Locationlist = new ArrayList();

		LocationVO lvo = new LocationVO();
		LocationDAO ldao = new LocationDAO();

		Locationlist = ldao.searchLocation(lvo);

		session.setAttribute("Locationlist", Locationlist);

		List ls = new ArrayList();
		LoginVO loginvo = new LoginVO();
		RegisterDAO logindao = new RegisterDAO();
		ls = logindao.search(loginvo);

		session.setAttribute("loginlist", ls);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("Ambulancelist", Ambulancelist);
		map.put("Locationlist", Locationlist);

		System.err.println("------Ambulancelist--------++++++++++"
				+ Ambulancelist.size() + "++++++--------------------");
		System.err.println("---------Locationlist-----++++++++"
				+ Locationlist.size() + "+++++++--------------------");

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		System.err.println(gson.toJson(map));
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		return "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if (flag.equals("insertLocation")) {

			insertLocation(request, response);
		}

		else if (flag.equals("insertLocation1")) {

			insertLocation1(request, response);
		}

		else if (flag.equals("updateLocation")) {

			update(request, response);
			// response.sendRedirect("ambulanceStaff/viewLocation.jsp");
			// delete(request,response);

		} else if (flag.equals("updatedrLocation")) {
			updatedrLocation(request, response);

		}
	}

	private void insertLocation1(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		float latitude = Float.parseFloat(request.getParameter("latitude"));
		float longitude = Float.parseFloat(request.getParameter("longitude"));
		int id1 = (int) request.getSession().getAttribute("userID");

		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk" + id1);

		LoginVO lv = new LoginVO();
		lv.setLoginID(id1);

		// AmbulanceVO ambulanceVO=new AmbulanceVO();
		// ambulanceVO.setAmbulanceNumber(ambulanceNumber);

		LocationVO lvo = new LocationVO();
		lvo.setLatitude(latitude);
		lvo.setLongitude(longitude);
		lvo.setStatus("open");
		// lvo.setAmbulanceVO(ambulanceVO);
		lvo.setLoginvo(lv);

		LocationDAO ldao = new LocationDAO();
		ldao.insertLocation(lvo);

		HttpSession session = request.getSession();

		session.setAttribute("lid", lvo.getLocationID());

		System.err
				.println("##########################################################################################################");
		response.sendRedirect("Doctor/indexd.jsp");

	}

	private void updatedrLocation(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

		List ls = new ArrayList();
		int ambulanceNumber = Integer.parseInt(request
				.getParameter("ambulanceNumber"));

		int locationID = Integer.parseInt(request.getParameter("locationID"));
		System.err.println("location id is --------------------------"
				+ locationID);
		/*
		 * float latitude=Float.parseFloat(request.getParameter("latitude"));
		 * float longitude=Float.parseFloat(request.getParameter("longitude"));
		 */

		AmbulanceVO ambulanceVO = new AmbulanceVO();
		ambulanceVO.setAmbulanceNumber(ambulanceNumber);

		LocationVO lvo = new LocationVO();

		lvo.setLocationID(locationID);
		// lvo.setLatitude(latitude);
		// lvo.setLongitude(longitude);

		LocationDAO ldao = new LocationDAO();
		lvo = (LocationVO) ldao.search(lvo).get(0);

		lvo.setStatus("close");
		lvo.setAmbulanceVO(ambulanceVO);

		ldao.closeModel(lvo);

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub

		String hospitalName = request.getParameter("hospitalName");

		int ambulanceNumber = Integer.parseInt(request.getParameter("ambulanceNumber"));

		int locationID = Integer.parseInt(request.getParameter("locationID"));
		System.err.println("location id is --------------------------"+ locationID);
		/*
		 * float latitude=Float.parseFloat(request.getParameter("latitude"));
		 * float longitude=Float.parseFloat(request.getParameter("longitude"));
		 */
		LocationVO lvo = new LocationVO();
		lvo.setLocationID(locationID);

		// lvo.setLatitude(latitude);
		// lvo.setLongitude(longitude);

		LocationDAO ldao = new LocationDAO();
		LocationVO lvo1 = new LocationVO();
		lvo1 = (LocationVO) ldao.search(lvo).get(0);

		AmbulanceVO ambulanceVO = new AmbulanceVO();
		ambulanceVO.setAmbulanceNumber(ambulanceNumber);
		
		HospitalVO hvo = new HospitalVO();
		hvo.setHospitalID(Integer.parseInt(hospitalName));
		lvo1.setHvo(hvo);

		lvo1.setStatus("inprogress");
		lvo1.setAmbulanceVO(ambulanceVO);

		ldao.updateModel(lvo1);
		
		HospitalDAO hospitalDAO = new HospitalDAO();
		List<HospitalVO> hsList = hospitalDAO.editHospital(hvo);
		
		request.getSession().setAttribute("contact", hsList.get(0).getContactNo());
		
		response.sendRedirect("ambulanceStaff/sendSMS.jsp");
	}

	/*
	 * private void delete(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub float
	 * latitude=Float.parseFloat(request.getParameter("latitude")); float
	 * longitude=Float.parseFloat(request.getParameter("longitude"));
	 * 
	 * LocationVO lvo=new LocationVO(); lvo.setLatitude(latitude);
	 * lvo.setLongitude(longitude);
	 * 
	 * LocationDAO ldao=new LocationDAO(); ldao.delete(lvo);
	 * 
	 * }
	 */

	/*
	 * private void delete(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub float
	 * latitude=Float.parseFloat(request.getParameter("latitude")); float
	 * longitude=Float.parseFloat(request.getParameter("longitude"));
	 * 
	 * LocationVO lvo=new LocationVO(); lvo.setLatitude(latitude);
	 * lvo.setLongitude(longitude);
	 * 
	 * LocationDAO ldao=new LocationDAO(); ldao.delete(lvo);
	 * 
	 * 
	 * 
	 * }
	 */
	private void insertLocation(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// int
		// ambulanceNumber=Integer.parseInt(request.getParameter("ambulanceNumber"));

		float latitude = Float.parseFloat(request.getParameter("latitude"));
		float longitude = Float.parseFloat(request.getParameter("longitude"));
		int id1 = (int) request.getSession().getAttribute("userID");

		System.out.println(id1);

		LoginVO lv = new LoginVO();
		lv.setLoginID(id1);

		// AmbulanceVO ambulanceVO=new AmbulanceVO();
		// ambulanceVO.setAmbulanceNumber(ambulanceNumber);

		LocationVO lvo = new LocationVO();
		lvo.setLatitude(latitude);
		lvo.setLongitude(longitude);
		lvo.setStatus("open");
		// lvo.setAmbulanceVO(ambulanceVO);
		lvo.setLoginvo(lv);

		LocationDAO ldao = new LocationDAO();
		ldao.insertLocation(lvo);

		HttpSession session = request.getSession();
		session.setAttribute("lid", lvo.getLocationID());

		System.err
				.println("##############################################################################################");
		response.sendRedirect("user/index.jsp");

	}

}
