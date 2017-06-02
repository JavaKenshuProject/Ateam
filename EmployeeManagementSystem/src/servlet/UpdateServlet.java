package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.SectionDAO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        SectionDAO sdao = new SectionDAO();
        EmployeeDAO edao = new EmployeeDAO();

        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");
        String lkana_name = request.getParameter("lkana_name");
        String fkana_name = request.getParameter("fkana_name");
        String sex = request.getParameter("sex");
        String sectionName = request.getParameter("sectionname");
        String action = request.getParameter("ACTION");


        HttpSession session1 = request.getSession();
        String empCode = (String)session1.getAttribute("empCode");


        String url = null;

//	        HttpSession session = request.getSession();

        if(action.equals("更新")) {

        	//入力がすべて行われていたらこっち
        	if(lname!=null && fname!=null && lkana_name!=null && fkana_name!=null
        			&& (sex.equals("1") || sex.equals("2")) && sectionName!=null){

        		 String sectionCode = sdao.searchSectionCode(sectionName);
//        		 System.out.println(sectionCode);
        		int count = edao.change(lname,fname,lkana_name,fkana_name,sex,sectionCode,empCode);

        		if(count==1){
        			 url = "alterEmployeeRegistration.jsp";
        		}else{
        			url = "alterEmployeeError.jsp";
        		}
        	}else{
        		url = "alterEmployeeError.jsp";
        	}

        }else {
        		url = "alterEmployee.jsp";
        }
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
	}

}
