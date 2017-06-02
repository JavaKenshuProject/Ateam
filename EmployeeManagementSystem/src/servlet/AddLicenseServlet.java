package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LicenseDAO;

/**
 * Servlet implementation class AddLicenseServlet
 */
@WebServlet("/AddLicenseServlet")
public class AddLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLicenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = null;
		String licenseCode = request.getParameter("licensecode");
		String licenseName = request.getParameter("licensename");
		System.out.println(licenseCode);
		System.out.println(licenseName);

		LicenseDAO dao = new LicenseDAO();
		int count = dao.addLicense(licenseCode, licenseName);

		if(count == 1){
			url = "licenseAddComp.jsp";
		}else{
			url = "licenseAddError.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
