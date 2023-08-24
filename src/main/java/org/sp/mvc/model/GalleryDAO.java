package org.sp.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sp.mvc.domain.Gallery;
import org.sp.mvc.util.PoolManager;

public class GalleryDAO {

	PoolManager pool=PoolManager.getInstance();
	
	//글 등록 
	public int insert(Gallery gallery) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //성공 ,실패 여부를 판단할 수 있는 변수..
		
		con=pool.getConnection();
		
		String sql="insert into gallery(gallery_idx, title, writer, content, filename)";
		sql+=" values(seq_gallery.nextval, ?,?,?,?)";

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			
			result=pstmt.executeUpdate();//DML 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	//모든 레코드 가져오기 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList();
		
		con=pool.getConnection();
		
		String sql="select * from gallery order by gallery_idx desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//레코드 수 만큼..
			while(rs.next()) {
				Gallery gallery = new Gallery();
				gallery.setGallery_idx(rs.getInt("gallery_idx"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
				
				list.add(gallery);//dto를 list에 담아두기
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
	
	//글상세보기
	public Gallery select(int gallery_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Gallery gallery=null;
		
		con=pool.getConnection();
		String sql="select * from gallery where gallery_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, gallery_idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				gallery = new Gallery();
				
				gallery.setGallery_idx(rs.getInt("gallery_idx"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return gallery;
	}
	
	//수정하기
	public int update(Gallery gallery) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql="update gallery set title=?, writer=?, content=?, filename=? where gallery_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			pstmt.setInt(5, gallery.getGallery_idx());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	
	//삭제하기 
	public int delete(int gallery_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql="delete from gallery where gallery_idx=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, gallery_idx);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
}


















