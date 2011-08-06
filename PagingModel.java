
import java.io.Serializable;
import java.util.List;

public class PagingModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_PAGE_SIZE = 10;

	protected PagingModel(List<T> pageData, int pageSize,
			int totalNumberOfData, int currentPage) {
		super();
		this.pageData = pageData;
		this.pageSize = pageSize;
		this.totalNumberOfData = totalNumberOfData;
		this.currentPage = currentPage;
		this.totalPages = calculateTotalPages();
	}

	protected PagingModel(List<T> pageData, int totalNumberOfData,
			int currentPage) {
		this(pageData, DEFAULT_PAGE_SIZE, totalNumberOfData, currentPage);
	}

	protected Object queryContext;
	
	protected List<T> pageData;

	protected int pageSize;

	protected int totalNumberOfData;

	protected int currentPage;

	protected int totalPages;

	public int getTotalPages() {
		return totalPages;
	}

	public int calculateTotalPages() {
		if (totalNumberOfData <= 0) {
			return 0;
		}
		if (pageSize <= 0) {
			return 0;
		}

		int count = totalNumberOfData / pageSize;
		if (totalNumberOfData % pageSize > 0) {
			count++;
		}
		return count;
	}

	public boolean isFirstPage() {
		return currentPage <= 1;
	}

	public boolean isLastPage() {
		return currentPage >= totalPages;
	}

	public int getPrePage() {
		if (isHasPrePage()) {
			return currentPage - 1;
		} else {
			return currentPage;
		}
	}

	public int getNextPage() {
		if (isHasNextPage()) {
			return currentPage + 1;
		} else {
			return currentPage;
		}
	}

	public boolean isHasPrePage() {
		return (currentPage - 1 >= 1);
	}

	public boolean isHasNextPage() {
		return (currentPage + 1 <= totalPages);
	}

	public int getStartRow() {
		if (pageSize <= 0 || totalNumberOfData <= 0)
			return 0;
		return currentPage > 0 ? (currentPage - 1) * pageSize + 1 : 0;
	}

	public int getEndRow() {
		return currentPage > 0 ? Math.min(pageSize * currentPage,
				totalNumberOfData) : 0;
	}

	public int getOffset() {
		return currentPage > 0 ? (currentPage - 1) * pageSize : 0;
	}

	public int getLimit() {
		if (currentPage > 0) {
			return Math.min(pageSize * currentPage, totalNumberOfData)
					- (pageSize * (currentPage - 1));
		} else {
			return 0;
		}
	}
	
	public Object getQueryContext() {
		return queryContext;
	}

	public void setQueryContext(Object queryContext) {
		this.queryContext = queryContext;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNumberOfData() {
		return totalNumberOfData;
	}

	public void setTotalNumberOfData(int totalNumberOfData) {
		this.totalNumberOfData = totalNumberOfData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static int getDEFAULT_PAGE_SIZE() {
		return DEFAULT_PAGE_SIZE;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}