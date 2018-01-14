package infomodule.pojo;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List list;  //要返回每一页的记录列表
	
	private int allRow;   //总记录数
	private int totalPage; //总页数
	private int currentPage;//当前页数
	private int pageSize;//每页记录数
	
	private boolean isFirstPage;//是否为第一页
	private boolean isLastPage;//是否为最后一页
	private boolean hasPrviousPage;//是否有前一夜
	private boolean hasNextPage;//是否有下一页
	
	public PageBean() {
		super();
	}

	public PageBean(List list, int allRow, int totalPage, int currentPage, int pageSize) {
		super();
		this.list = list;
		this.allRow = allRow;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public boolean isFirstPage(){
		return (currentPage==1);
	}
	
	public boolean isLastPage(){
		return (currentPage==totalPage);
	}
	
	public boolean isHasPrviosPage(){
		return currentPage!=1;
	}
	
	public boolean isHasNextPage(){
		return currentPage!=totalPage;
	}
	
	//总页数
	public static int countTotalPage(final int pageSize,final int allRow){
		return allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
	}
	
	//每一页的开始记录
	public static int countOffset(final int currentPage,final int pageSize){
		return pageSize*(currentPage-1);
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public boolean isHasPrviousPage() {
		return hasPrviousPage;
	}
	public void setHasPrviousPage(boolean hasPrviousPage) {
		this.hasPrviousPage = hasPrviousPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list + ", allRow=" + allRow + ", totalPage=" + totalPage + ", currentPage="
				+ currentPage + ", pageSize=" + pageSize + ", isFirstPage=" + isFirstPage + ", isLastPage=" + isLastPage
				+ ", hasPrviousPage=" + hasPrviousPage + ", hasNextPage=" + hasNextPage + "]";
	}
	
}
