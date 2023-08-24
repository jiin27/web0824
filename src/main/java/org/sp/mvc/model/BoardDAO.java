package org.sp.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sp.mvc.domain.Board;
import org.sp.mvc.util.PoolManager;

public class BoardDAO {
	PoolManager pool=PoolManager.getInstance();
	
	public List selectAll() {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list = new ArrayList();
		
		try {
			con=pool.getConnection(); //대여
			
			String sql="select * from board order by board_idx desc";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoard_idx(rs.getInt("board_idx"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				board.setContent(rs.getString("content"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
	
	public int insert(Board board) {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="jsp";
		String pass="1234";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=pool.getConnection(); //대여
			
			String sql="insert into board(board_idx, title, writer ,content)";
			sql+=" values(seq_board.nextval, ?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	// 레코드 한건 가져오기 
	public Board select(int board_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board board=null;
		
		con=pool.getConnection(); //대여
		
		String sql="select * from board where board_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_idx);
			rs=pstmt.executeQuery();
			
			//레코드가 있다면...
			if(rs.next()) {
				board = new Board();//empty
				
				board.setBoard_idx(rs.getInt("board_idx"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				board.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return board;
	}
	
	//글한건 수정하기 
	public int update(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //DML 수행후 그 결과를 알수있는 변수
		
		con=pool.getConnection();//대여
		
		String sql="update board set title=?, writer=?, content=?";
		sql+=" where board_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());//제목
			pstmt.setString(2, board.getWriter());//작성자
			pstmt.setString(3, board.getContent());//내용
			pstmt.setInt(4, board.getBoard_idx());//pk
			
			result=pstmt.executeUpdate(); //DML 수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	//레코드 1건 삭제 
	public int delete(int board_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql="delete board where board_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_idx);
			result=pstmt.executeUpdate(); //DML 실행
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
}














