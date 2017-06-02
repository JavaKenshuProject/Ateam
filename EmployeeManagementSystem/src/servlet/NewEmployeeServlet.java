/*
 *Employee_Management_System  NewEmployeeServlet.java
 */

/**
 * 従業員情報を新規登録するクラス
 *
 * 本田
 * @version 1.00
 */

/**
 * メソッドの説明  メソッドの説明を簡潔に記述する（例：面積を求める。）
 * パラメータの説明  仮引数の名前とその説明を宣言順に記述する（例：@param hight 高さ）
 * 戻り値の説明  戻り値がある場合に戻り値の説明を記述する（例：@return 面積の値）
 */
package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.LicenseDAO;
import dao.SectionDAO;

/**
 * Servlet implementation class NewEmployeeServlet
 */
@WebServlet("/NewEmployeeServlet")
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("employeeRegistration.jsp");
        rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = 0;

		//エンコーディング指定
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //入力した情報を取得
        EmployeeDAO edao = new EmployeeDAO();
        SectionDAO sdao = new SectionDAO();
        LicenseDAO ldao = new LicenseDAO();

        String empCode = request.getParameter("empCode");
        String lName = request.getParameter("lName");
        String fName = request.getParameter("fName");
        String lRubyName = request.getParameter("lRubyName");
        String fRubyName = request.getParameter("fRubyName");
        String sex = request.getParameter("sex");
        String birthYear = request.getParameter("birthYear");
        System.out.println(birthYear);
        String birthMonth = request.getParameter("birthMonth");
        String birthDate = request.getParameter("birthDate");
        String empYear = request.getParameter("empYear");
        String empMonth = request.getParameter("empMonth");
        String empDate = request.getParameter("empDate");
        String sectionName = request.getParameter("section");
        String licenseName = request.getParameter("license");
        String birthDay = birthYear + birthMonth + birthDate;
        empDate = empYear + empMonth + empDate;

        String sectionCode = sdao.searchSectionCode(sectionName);

        if(licenseName != null){
            count = edao.NewEmployee(empCode, lName, fName, lRubyName, fRubyName, sex, birthDay, sectionCode, empDate);
        	if(count == 1){
        	}
        }

     // 移譲する先のjspを格納する変数url
        String url = null;
        if(count == 1){
        	if(!(licenseName.equals("no"))){
            	String licenseCode = ldao.getMLicenseCode(licenseName);
                java.util.Date d = new java.util.Date();
                java.sql.Date date = new java.sql.Date(d.getTime());
            	ldao.insert_license(empCode, licenseCode, date);
        	}
        	url = "employeeRegistrationComp.jsp";
        }else if(count == 0){
        	url = "employeeRegistrationError.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);


	}

}
