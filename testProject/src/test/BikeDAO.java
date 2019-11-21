package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BikeDAO {
	public int insertBike(BikeDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into bike values(?,?,?,?,?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getP_number());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getProduct());
			pstmt.setInt(4, dto.getYear());
			pstmt.setInt(5, dto.getMileage());
			pstmt.setInt(6, dto.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}//insertBike()
	
	public int deleteBike(String p_number) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from bike where p_number = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, p_number);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}//deleteBike()
	
	public int updateBike(BikeDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("update bike set company = ?, product = ?, year = ?");
			sb.append(", mileage = ?, price = ? where p_number = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getCompany());
			pstmt.setString(2, dto.getProduct());
			pstmt.setInt(3, dto.getYear());
			pstmt.setInt(4, dto.getMileage());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setString(6, dto.getP_number());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}//updateBike()
	
	public BikeDTO viewBike(String p_number) {
		BikeDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("select p_number, company, product, year, mileage, price ");
			sb.append(" from bike where p_number = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, p_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String company = rs.getString("company");
				String product = rs.getString("product");
				int year = rs.getInt("year");
				int mileage = rs.getInt("mileage");
				int price = rs.getInt("price");
				dto = new BikeDTO(p_number, company, product, year, mileage, price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//viewBike()
	
	public Vector searchBike(String product) {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("select p_number, company, product, year, mileage, price ");
			sb.append(" from bike where product like ? order by company desc, product");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+product+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("p_number"));
				row.add(rs.getString("company"));
				row.add(rs.getString("product"));
				row.add(rs.getInt("year"));
				row.add(rs.getInt("mileage"));
				row.add(rs.getInt("price"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return items;	
	}//serchBike()
	
	public Vector listBike() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("select p_number, company, product, year, mileage, price ");
			sb.append(" from bike order by company desc, product");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector row = new Vector();
				row.add(rs.getString("p_number"));
				row.add(rs.getString("company"));
				row.add(rs.getString("product"));
				row.add(rs.getInt("year"));
				row.add(rs.getInt("mileage"));
				row.add(rs.getInt("price"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return items;
	}//listBike()

}
