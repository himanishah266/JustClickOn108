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

import DAO.StateDAO;
import VO.StateVO;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
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
			search(request,response);
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
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("stateID"));
		StateVO statevo=new StateVO();
		
		statevo.setStateID(id);
     StateDAO dao=new StateDAO();
     
     dao.delete(statevo);
     
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		int id=Integer.parseInt(request.getParameter("stateID"));
		StateVO statevo=new StateVO();
		statevo.setStateID(id);
		
		StateDAO statedao=new StateDAO();
		ls=statedao.edit(statevo);
		
		HttpSession session=request.getSession();
		session.setAttribute("list", ls);
		
		response.sendRedirect("admin/editState.jsp");

	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// TODO Auto-generated method stub
		
		
		
		List ls=new ArrayList();
		StateVO statevo=new StateVO();
		
		StateDAO dao=new StateDAO();
		
		ls=dao.search(statevo);
		HttpSession session=request.getSession();
		session.setAttribute("list", ls);
		response.sendRedirect("admin/viewState.jsp");
		
		
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
			update(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(request.getParameter("stateID"));
		String n=request.getParameter("stateName");
		
		StateVO vo=new StateVO();
		vo.setStateName(n);
		vo.setStateID(id);
		vo.setDeleteStatus("active");
		
		
		StateDAO dao=new StateDAO();
		dao.update(vo);
		
		search(request,response);
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		
		String n=request.getParameter("stateName");
		
		StateVO vo=new StateVO();
		vo.setStateName(n);
		vo.setDeleteStatus("active");
		
		StateDAO dao=new StateDAO();
		dao.insert(vo);
		
		response.sendRedirect("admin/addState.jsp");
		
	}

}
