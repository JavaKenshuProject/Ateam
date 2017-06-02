package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.LicenseDAO;
import dao.SectionDAO;
import entity.EmployeeBean;

/**
 * Servlet implementation class AllEmployeeServlet
 */
@WebServlet("/AllEmployeeServlet")
public class AllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ArrayList<EmployeeBean> employeeList = new ArrayList<>();
		HashMap<String, String> licenseList = new HashMap<>();

		EmployeeDAO edao = new EmployeeDAO();
		LicenseDAO ldao = new LicenseDAO();
		SectionDAO sdao = new SectionDAO();

		String licenseCode = null;
		String licenseName = null;

		employeeList = edao.selectAll();
		for(int i=0;i<employeeList.size();i++){
			licenseCode = ldao.getLicenseCode(employeeList.get(i).getEmpCode());
			if(licenseCode != null){
				licenseName = ldao.getLicenseName(licenseCode);
				licenseList.put(String.valueOf(i), licenseName);
			}
			employeeList.get(i).setSectionName(sdao.searchSectionName(employeeList.get(i).getSectionName()));
		}

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("employeeList", employeeList);
		httpSession.setAttribute("licenseList", licenseList);

		RequestDispatcher rd = request.getRequestDispatcher("./allEmployee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
