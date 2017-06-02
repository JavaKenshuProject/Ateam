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

        String empCode = request.getParameter("empCode");
        String lName = request.getParameter("lName");
        String fName = request.getParameter("fName");
        String lRubyName = request.getParameter("lRubyName");
        String fRubyName = request.getParameter("fRubyName");
        String sex = request.getParameter("sex");
        String birthDay = request.getParameter("birthDay");
        String sectionName = request.getParameter("busyo");
        String empDate = request.getParameter("empDate");

        String sectionCode = sdao.searchSectionCode(sectionName);

        String kana = "^[\\u30A0-\\u30FF]+$";
        String num = "\\A[-]?[0-9]+\\z";

        // 移譲する先のjspを格納する変数url
        String url = null;

        if(empCode!=null && lName!=null && fName!=null && lRubyName!=null && fRubyName!=null){

			if(lRubyName.matches(kana) && fRubyName.matches(kana)
					&& !(lName.matches(num)) && !(fName.matches(num))
					&& !(lRubyName.matches(num)) && !(fRubyName.matches(num))){

				if(empCode.matches("[0-9a-zA-Z]+")){
			        count = edao.NewEmployee(empCode, lName, fName
			        	, lRubyName, fRubyName, sex, birthDay, sectionCode, empDate);
				}else{
					url = "employeeRegistrationError.jsp";
				}
			}else{
				url = "employeeRegistrationError.jsp";
			}
		}else{
			url = "employeeRegistrationError.jsp";
		}




        if(count == 1){
        	url = "employeeRegistrationComp.jsp";
        }else if(count == 0){
        	url = "employeeRegistrationError.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

	}
}
