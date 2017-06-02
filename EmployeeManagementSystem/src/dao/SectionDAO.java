package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionDAO {

	public String searchSectionName(String sectionCode){
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "SELECT section_name FROM m_section where section_code = '"+sectionCode+"';";
        String sectionName = null;

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

	public String searchSectionCode(String sectionName){
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "SELECT section_code FROM m_section where section_name = '"+sectionName+"';";
        String sectionCode  = null;
        try(Connection con = cm.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet res = ps.executeQuery();

            // 結果の取得
            while(res.next()) {
            	sectionCode = res.getString(1);
            }

        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        cm.closeConnection();
        return sectionCode;
	}

}
