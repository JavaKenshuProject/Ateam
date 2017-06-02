package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.EmployeeBean;

public class EmployeeDAO {

	public ArrayList<EmployeeBean> selectAll(){
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "SELECT * FROM m_employee;";
		ArrayList<EmployeeBean> employeeList = new ArrayList<>();
		String sex = null;

        try(Connection con = cm.getConnection();
                Statement stmt = con.createStatement()) {

            ResultSet res = stmt.executeQuery(sql);

            // 結果の取得
            while(res.next()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setEmpCode(res.getString(1));
                employee.setlName(res.getString(2));
                employee.setfName(res.getString(3));
                employee.setlRubyName(res.getString(4));
                employee.setfRubyName(res.getString(5));
                if(res.getInt(6) == 1){
                	sex = "男";
                }else{
                	sex = "女";
                }
                employee.setSex(sex);
                employee.setBirthDay(res.getDate(7));
                employee.setSectionName(res.getString(8));
                employee.setEmpDate(res.getDate(9));
                employee.setUpdateDate(res.getTimestamp(10));
                employeeList.add(employee);
            }

        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        cm.closeConnection();
        return employeeList;
	}

	public int deleteEmployee(String empCode){
        ConnectionManager cm = ConnectionManager.getInstance();

        int count = 0;
        String sql = "delete from m_employee where emp_code = '"+empCode+"'";

        try(Connection con = cm.getConnection();
        		PreparedStatement ps = con.prepareStatement(sql)){

        	count = ps.executeUpdate();
        	System.out.println(count);
        } catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        cm.closeConnection();
		return count;

	}

	public EmployeeBean searchEmployee(String empCode){
        ConnectionManager cm = ConnectionManager.getInstance();

        EmployeeBean employee = new EmployeeBean();

        String sql = "SELECT * FROM m_employee where emp_code = '"+empCode+"';";
        String sex;

        try(Connection con = cm.getConnection();
                Statement stmt = con.createStatement()) {

            ResultSet res = stmt.executeQuery(sql);

            // 結果の取得
            while(res.next()) {
                employee = new EmployeeBean();
                employee.setEmpCode(res.getString(1));
                employee.setlName(res.getString(2));
                employee.setfName(res.getString(3));
                employee.setlRubyName(res.getString(4));
                employee.setfRubyName(res.getString(5));
                if(res.getInt(6) == 1){
                	sex = "男";
                }else{
                	sex = "女";
                }
                employee.setSex(sex);
                employee.setBirthDay(res.getDate(7));
                employee.setSectionName(res.getString(8));
                employee.setEmpDate(res.getDate(9));
                employee.setUpdateDate(res.getTimestamp(10));
            }

        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        cm.closeConnection();
        return employee;
	}

	public String searchSectionName(String sectionCode){
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "SELECT section_name FROM m_section where section_code = '"+sectionCode+"';";
        String sectionName  = null;
        try(Connection con = cm.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet res = ps.executeQuery();

            // 結果の取得
            while(res.next()) {
            	sectionName = res.getString(1);
            }

        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        cm.closeConnection();
        return sectionName;
	}

	public int change(String lname,String fname,String lkana_name,String fkana_name,
			String sex,String sectionCode,String empCode){
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "update m_employee set l_name = '"+lname+"',f_name = '"+fname+"',l_kana_name = '"+lkana_name+"',f_kana_name = '"+fkana_name+"'"
        			+ ",sex = '"+sex+"',section_code = '"+sectionCode+"' where emp_code = '"+empCode+"';";
        int count = 0;
        try(Connection con = cm.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {


           count = ps.executeUpdate();


        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        cm.closeConnection();
        return count;
	}

	public int NewEmployee(String empCode, String lName, String fName, String lRubyName, String fRubyName,
			String sex, String birthDay, String sectionCode, String empDate) {
		ConnectionManager cm = ConnectionManager.getInstance();

		int count = 0;
        //SQL文
		String sql =
				"INSERT INTO m_employee (emp_code, l_name, f_name, l_kana_name, f_kana_name, sex, birth_day, section_code, emp_date) VALUES ('"+empCode+"', '"+lName+"', '"+fName+"', '"+lRubyName+"', '"+fRubyName+"', '"+Integer.parseInt(sex)+"', '"+birthDay+"', '"+sectionCode+"', '"+empDate+"');";
        try(Connection con = cm.getConnection();
        		PreparedStatement ps = con.prepareStatement(sql)){

        count = ps.executeUpdate();

        }catch(SQLException e){
        	System.out.println("処理結果：異常が発生しました");
        	e.printStackTrace();
        }
        cm.closeConnection();
        return count;

	}

}
