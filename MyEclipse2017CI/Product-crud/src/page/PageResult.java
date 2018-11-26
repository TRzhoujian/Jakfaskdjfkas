package page;

import java.util.List;

import lombok.Getter;
import lombok.ToString;
@SuppressWarnings("all")
@Getter
@ToString
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
	
	
	
}
