package mn.sis.springweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import mn.sis.menu.Menu;
import mn.sis.menu.Modul;

public class CustomerDaoImpl implements CustomerDao {

	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Customer customer){
 
		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public Customer findByCustomerId(int custId){
 
		String sql = "SELECT CUSTOMERPKID, 10 AGE, FIRSTNAME FROM tb_customer WHERE CUSTOMERPKID=?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUSTOMERPKID"),
					rs.getString("FIRSTNAME"), 
					rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public List<Modul> findModelMenu(){
		 
		String sql = "SELECT md.MODULPKID, md.displayname MODULNAME, md.MODULUNIQNAME, m.MENUPKID, m.displayname MENUNAME FROM tb_menu m INNER JOIN tb_role_menu rm ON m.menupkid = rm.menupkid INNER JOIN tb_modul md ON md.modulpkid = m.modulpkid WHERE rm.role_id = ?";  
		
		Connection conn = null;
 
		List<Modul> modulList = new ArrayList<Modul>();
		Modul modul;
		Menu menu;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
		
				int modulPkId = rs.getInt("MODULPKID");
				String modulName = rs.getString("MODULNAME");
				
				
				menu = new Menu(rs.getInt("MENUPKID"), rs.getString("MENUNAME"), "");
				
				int modulIndex = modulExist(modulList, modulPkId);
				if(modulIndex == -1)
				{
					modul = new Modul(modulPkId, modulName);
					modul.getMenuList().add(menu);
					modulList.add(modul);
				}
				else
				{
					modulList.get(modulIndex).getMenuList().add(menu);
				}
			}
			rs.close();
			ps.close();
			return modulList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	private int modulExist(List<Modul> modulList, int modulPkId)
	{
		for(int ix = 0; ix < modulList.size(); ix ++)
		{
			if(modulList.get(ix).getModulPkid() == modulPkId)
			{
				return ix;
			}
		}
		
		return -1;
	}
}
