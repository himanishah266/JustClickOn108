package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.RegisterDAO;
import VO.LoginVO;
import VO.RegisterVO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fn=request.getParameter("firstName");
		String ln=request.getParameter("lastName");
		String un=request.getParameter("userName");
		String cpass=request.getParameter("confirmPassword");
		String userType=request.getParameter("radio");

	
		LoginVO loginvo=new LoginVO();
		
		loginvo.setUserName(un);
		loginvo.setPassword(cpass);
		loginvo.setUserType(userType);
		
		RegisterVO registervo=new RegisterVO();
		
		registervo.setFirstName(fn);
		registervo.setLastName(ln);	
		registervo.setLoginvo(loginvo);
		
		
		RegisterDAO registerdao=new RegisterDAO();

		registerdao.insert(loginvo);
		registerdao.insert(registervo);
		
		
		response.sendRedirect("admin/login.jsp");
		

		
	}

}
