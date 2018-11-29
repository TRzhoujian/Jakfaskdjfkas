package page;

import java.util.List;
@SuppressWarnings("all")

public class PageResult {
	private List listData;
	private Integer totalCount;
	private Integer currentPage = 1;
	private Integer PageSize = 10;
	private Integer beginPage = 1;
	private Integer totalPage;
	private Integer prevPage;
	private Integer nextPage;
	public PageResult(List listData, Integer totalCount, Integer currentPage, Integer pageSize) {
		super();
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.PageSize = pageSize;

		this.totalPage = this.totalCount%this.PageSize == 0 ?this.totalCount/this.PageSize:this.totalCount/this.PageSize+1;
		this.prevPage = this.currentPage -1 >=1?this.currentPage-1 :1;
		this.nextPage = this.currentPage +1 <=this.totalPage?this.currentPage+1 :this.totalPage;
	}
	
	@Override
	public String toString() {
		return "PageResult [listData=" + listData + ", totalCount=" + totalCount + ", currentPage=" + currentPage
				+ ", PageSize=" + PageSize + ", beginPage=" + beginPage + ", totalPage=" + totalPage + ", prevPage="
				+ prevPage + ", nextPage=" + nextPage + "]";
	}
	public List getListData() {
		return listData;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getPageSize() {
		return PageSize;
	}
	public Integer getBeginPage() {
		return beginPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	
	
	
}
