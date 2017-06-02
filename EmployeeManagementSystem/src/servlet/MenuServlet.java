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
import entity.EmployeeBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = "menu.jsp";
		String menu = request.getParameter("menu");

		if(menu.equals("資格追加")){
			url = "licenseAdd.jsp";
		}else if(menu.equals("資格取得")){
			url = "licenseRegistration.jsp";
		}else if(menu.equals("従業員登録")){
			url = "employeeRegistration.jsp";
		}else if(menu.equals("システム利用者登録")){
			url = "userRegistration.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession httpSession = request.getSession();
		String url = "menu.jsp";
		String menu = request.getParameter("menu");

		if(menu.equals("戻る")){
			String from = request.getParameter("from");
			switch (from) {
			case "ユーザ登録エラー":
				url = "userRegistration.jsp";
				break;
			case "保有資格登録エラー":
				url = "licenseRegistration.jsp";
				break;
			case "ログインエラー":
				url = "login.jsp";
				break;
			case "資格追加エラー":
				url = "licenseAdd.jsp";
				break;
			case "従業員登録エラー":
				url = "employeeRegistration.jsp";
				break;
			case "変更エラー":
				url = "alterEmployee.jsp";
				break;
			case "削除エラー":
				url = "allEmployeeDelete.jsp";
				break;
			case "チェックエラー":
				url = "allEmployee.jsp";
				break;
			}
		}else{
			String empCode = request.getParameter("empcode");
			if(empCode == null){
				url = "checkError.jsp";
			}else{
				if(menu.equals("変更")){

					EmployeeBean employee = new EmployeeBean();
					EmployeeDAO edao = new EmployeeDAO();

					employee = edao.searchEmployee(empCode);
					String sectionName = edao.searchSectionName(employee.getSectionName());
					employee.setSectionName(sectionName);

					httpSession.setAttribute("employee", employee);
					url = "alterEmployee.jsp";
				}else if(menu.equals("削除")){

					httpSession.setAttribute("empCode", empCode);
					url = "/DeleteServlet";
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
