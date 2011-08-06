import java.util.List;


public interface UserManager {
	List<User> find(User query,int offset,int size);
	PagingModel<User> findPage(User query,int pageSize,int currentPage);
	PagingModel<User> findPage(User query,int currentPage);
}
