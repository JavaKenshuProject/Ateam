package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LicenseDAO {

	public int addLicense(String licenseCode,String licenseName){
		ConnectionManager cm = ConnectionManager.getInstance();

		String sql = "insert into m_license values('"+licenseCode+"','"+licenseName+"');";
		int count = 0;

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			count = ps.executeUpdate();
			System.out.println("エラー");
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
		return count;
	}

	public String searchSecsionCode(String license_name){

		// 返す資格コード
		String license_code = null;

		// データベースに繋ぐやつ
		ConnectionManager cm = ConnectionManager.getInstance();
		try(Connection con = cm.getConnection();
                Statement stmt = con.createStatement()) {

            // 資格マスタからレコード取ってくる
            ResultSet res = stmt.executeQuery("SELECT * FROM m_license");

            // 1行ずつ
            while(res.next()){
            	// 同じやつがあったらコード取得
            	if(license_name.equals(res.getString("license_name"))){
            		license_code = res.getString("license_cd");
            		break;
            	} else {
            		continue;
            	}
            }

        // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
		cm.closeConnection();
		// 資格コード返す
		return license_code;
	}

	public int insert_license(String emp_code, String license_code, Date dt){

		// データベースと接続
		ConnectionManager cm = ConnectionManager.getInstance();

		// INSERTの成否を表す変数
		int count = 0;

		try(Connection con = cm.getConnection();
                Statement stmt = con.createStatement()) {
			// SQL文、従業員コードと資格コードと日付を資格マスタのテーブルデータに追加
			String sql = "INSERT INTO t_get_license(emp_code,license_cd, get_license_date) VALUES('"+emp_code+"', '"+license_code+"', '"+dt.toString()+"') ";
			count = stmt.executeUpdate(sql);

		// SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
		cm.closeConnection();
		// 成否返す
		return count;

	}

	public void deleteLicense(String empCode){
		ConnectionManager cm = ConnectionManager.getInstance();

		String sql = "delete from t_get_license where emp_code = '"+empCode+"';";

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
	}

	public String getLicenseCode(String empCode){
		ConnectionManager cm = ConnectionManager.getInstance();

		String licenseCode = null;
		String sql = "select license_cd from t_get_license where emp_code = '"+empCode+"'";

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet res = ps.executeQuery();
			if(res.next()){
				licenseCode = res.getString(1);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
		return licenseCode;
	}

	public String getMLicenseCode(String licenseName){
		ConnectionManager cm = ConnectionManager.getInstance();

		String licenseCode = null;
		String sql = "select license_cd from m_license where license_name = '"+licenseName+"'";

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet res = ps.executeQuery();
			if(res.next()){
				licenseCode = res.getString(1);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
		return licenseCode;
	}

	public String getLicenseName(String licenseCode){
		ConnectionManager cm = ConnectionManager.getInstance();

		String licenseName = null;
		String sql = "select license_name from m_license where license_cd = '"+licenseCode+"'";

		try(Connection con = cm.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet res = ps.executeQuery();
			if(res.next()){
				licenseName = res.getString(1);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cm.closeConnection();
		return licenseName;
	}

}
