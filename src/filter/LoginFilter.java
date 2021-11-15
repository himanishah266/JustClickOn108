package filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.AmbulanceDAO;
import DAO.HospitalDAO;
import DAO.LocationDAO;
import DAO.RegisterDAO;
import VO.AmbulanceVO;
import VO.HospitalVO;
import VO.LocationVO;
import VO.LoginVO;
import VO.StaffVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");
		
		String uri = ((HttpServletRequest) request).getRequestURI();

	System.out.println("<<<<<Before >>>>>>>"+uri);
	
		if(uri.contains("sendSMS.jsp")|| uri.contains("sendLocationController")|| uri.contains("RegisterController")||uri.contains("/css") ||uri.contains("/js") &&!uri.contains(".jsp") ||uri.contains("/imges")||uri.contains("/image")||uri.contains("/Login.jsp") ||uri.contains("/fonts") ||uri.contains("/register.jsp")||uri.contains("/step1.jsp")||uri.contains("/forgetPassword"))
		
		{
			System.out.println("<<<<<After >>>>>>>"+uri);
			chain.doFilter(request, response);
		}
		else if (flag!= null && flag.equals("logout")){
			
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			requestDispatcher.forward(request, response);
		}
		else if (flag!= null && flag.equals("login"))
		{
			String username=request.getParameter("userName");
			String password=request.getParameter("password");
          
          System.out.println(username+""+password);
          
          LoginVO loginvo=new LoginVO();
          loginvo.setUserName(username);
          loginvo.setPassword(password);
          
          RegisterDAO registerdao = new RegisterDAO(); 
          
			List list =  registerdao.authentication(loginvo);
			System.out.println("list Size>>>>>>>>>>"+list.size());
			if(list != null && list.size()>=1){
				
				//Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				LoginVO user=(LoginVO) list.get(0);
				
				int y = user.getLoginID();
				session.setAttribute("userID",y);
				
			//System.out.println(user.getRadio());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUserType();
				session.setAttribute("userType",type);
				System.out.println("+++++++++userid++++++++++"+y);
				System.out.println(type);
				
				if(type.equalsIgnoreCase("admin"))
				{
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("user"))
				{
					requestDispatcher = request.getRequestDispatcher("/user/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("ambulanceStaff"))
				{
					
					AmbulanceVO ambulanceVO = new AmbulanceVO();
					AmbulanceDAO ambulanceDAO = new AmbulanceDAO();
					List ambList = ambulanceDAO.searchAmbulance(ambulanceVO);
					
					HospitalVO hvo = new HospitalVO();
					HospitalDAO hospitalDAO = new HospitalDAO();
					List hsList = hospitalDAO.searchHospital(hvo);
					
					session.setAttribute("searchlist", hsList);
					session.setAttribute("Ambulancelist", ambList);
					
					requestDispatcher = request.getRequestDispatcher("/ambulanceStaff/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("driver"))
				{
					
					LoginVO loginVO2 = new LoginVO();
					loginVO2.setLoginID(y);
					
					List<LocationVO> DriverAndCaseList = new ArrayList<LocationVO>();
					
					LocationDAO locationDAO = new LocationDAO();
					List<StaffVO> DriverList = locationDAO.DriverByLogin(loginVO2);
					for (StaffVO staffVO : DriverList) {
						DriverAndCaseList =locationDAO.DriverAndCase(staffVO);
					}
					
					session.setAttribute("DriverAndCaseList", DriverAndCaseList);
					
					requestDispatcher = request.getRequestDispatcher("/Driver/indexd.jsp");  
					requestDispatcher.forward(request,response);
				}
				
				
				
				else
				{
					requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}
			
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
				rd.forward(request,response);  
				
			}
		}
			
			
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("userType");
			//System.out.println("type = = = " + h);
			
			if(h!=null && h.equals("admin")){
				
			//System.out.println("chain");
			chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("user"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
			else if(h!=null && h.equals("ambulanceStaff"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
			else if(h!=null && h.equals("driver"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
	
	
			
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
				rd.forward(request,response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
			rd.forward(request,response);  
			
		}
	}
	

          
	/**

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
