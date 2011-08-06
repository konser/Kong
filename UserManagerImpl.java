import java.util.Collections;
import java.util.List;


public class UserManagerImpl implements UserManager {

	public int findCount(User query){
		return -1;
	}
	
	public List<User> find(User query,int offset,int size) {
		return Collections.emptyList();
	}
	
	@Override
	public PagingModel<User> findPage(User query, int pageSize, int currentPage) {
		int total = findCount(query);
		PagingModel<User> result = new PagingModel<User>();
		result.setTotalNumberOfData(total);
		result.setPageSize(pageSize);
		result.setCurrentPage(currentPage);
		result.setTotalPages(result.calculateTotalPages());
		List<User> pageData = find(query,result.getOffset(),pageSize);
		result.setPageData(pageData);
		result.setQueryContext(query);
		return result;
	}

	@Override
	public PagingModel<User> findPage(User query, int currentPage) {
		return findPage(query,PagingModel.DEFAULT_PAGE_SIZE,currentPage);
	}

}
