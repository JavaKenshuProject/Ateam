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
        String sectionName = request.getParameter("sectionName");
        System.out.println(sectionName);
        int count = 0;

        HttpSession session1 = request.getSession();
        String empCode = (String)session1.getAttribute("empCode");


        String url = null;
        String kana = "^[\\u30A0-\\u30FF]+$";
        String num = "\\A[-]?[0-9]+\\z";


//	        HttpSession session = request.getSession();

        	//入力がすべて行われていたらこっち
        	/*
        	 * String katakana = "カタカナ";
				if (katakana.matches("^[\\u30A0-\\u30FF]+$")) {
    			System.out.println("全てカタカナ");
    			 "\\A[-]?[0-9]+\\z"=数字かの判断
        	 */
        	if(lname!=null && fname!=null && lkana_name!=null && fkana_name!=null && sectionName!=null){

        		if(lkana_name.matches(kana) || fkana_name.matches(kana)
        				|| !(lname.matches(num)) || !(fname.matches(num))
        							|| !(lkana_name.matches(num)) || !(fkana_name.matches(num))){
        				String sectionCode = sdao.searchSectionCode(sectionName);

        		        count = edao.change(lname,fname,lkana_name,fkana_name,sex,sectionCode,empCode);
        		}else{
        			url = "alterEmployeeError.jsp";
        	}



        	if(count==1){
        			url = "alterEmployeeRegistration.jsp";
        	}else{
        			url = "alterEmployeeError.jsp";
        		}
        	}else{
        		url = "alterEmployeeError.jsp";
        	}

    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
	}

}
