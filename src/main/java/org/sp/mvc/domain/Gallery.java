package org.sp.mvc.domain;

public class Gallery {
	private int gallery_idx;
	private String title;
	private String writer;
	private String content;
	private String filename;
	private String regdate;
	private int hit;
	
	public int getGallery_idx() {
		return gallery_idx;
	}
	public void setGallery_idx(int gallery_idx) {
		this.gallery_idx = gallery_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
