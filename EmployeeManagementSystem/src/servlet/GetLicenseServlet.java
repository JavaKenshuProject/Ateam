package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LicenseDAO;

@WebServlet("/GetLicenseServlet")
public class GetLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public GetLicenseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エラー画面で[戻る]ボタン押したとき、前の画面に戻る
		String url = "licenceRegistration.jsp";

		// 遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エンコーディング指定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // formからの値を取得
        String emp_code     = request.getParameter("emp_code");        // 従業員コード
        String license_name = request.getParameter("license_name");    // 資格名

        // 変数宣言
        String license_code = null;   // 資格コード
        int count;                    // INSERT出来てるか判定(0 : 失敗, 1 : 成功)

        // 移譲する先のjspを格納する変数url
        String url = null;

        // DAOをインスタンス化
        LicenseDAO       ldao = new LicenseDAO();

        // 資格コード取得
        try{
        	license_code = ldao.searchSecsionCode(license_name);
        } catch(Exception e){
        	e.printStackTrace();
        }

        // 時間
        java.util.Date d = new java.util.Date();
        java.sql.Date date = new java.sql.Date(d.getTime());

        // INSERT判定
        count = ldao.insert_license(emp_code, license_code, date);
        System.out.println(count);
        if(count == 0){
        	// 失敗
        	url = "licenseRegistrationError.jsp";
        } else if(count == 1){
        	// 成功
        	url = "licenseRegistrationComp.jsp";
        }

        // 遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}