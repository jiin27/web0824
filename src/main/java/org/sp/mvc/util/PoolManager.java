package org.sp.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JNDI를 이용한 커넥션 풀 객체를 이 클래스에서 검색하여 보관..
public class PoolManager {
	private static PoolManager instance;
	InitialContext context;
	DataSource ds;
	
	//생성자를 아무나 호출하지 못하도록 
	private PoolManager() {
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}			
	}
	
	//PoolManager 자료형을 외부의 객체들이 가져갈 수 있도록, getter 제공 
	public static PoolManager getInstance() {
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	
	//풀로부터 커넥션을 빌려가도록 제동하는 메서드 정의 
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection(); //풀로부터 Connection 객체 얻기
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//사용이 끝나고, 다시 돌려보내기
	public void release(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DML 수행시
	public void release(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Select 수행시 
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}





