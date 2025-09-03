package walker.mybatisdaoj.test.dao;

import walker.mybatis.paginator.PageBounds;
import org.apache.ibatis.annotations.Param;
import walker.mybatisdaoj.test.common.BasicDao;
import java.util.ArrayList;
import java.util.Map;

import walker.mybatisdaoj.test.dpo.Book;
import walker.mybatisdaoj.test.dpo.EditorExt;

public interface BookDao extends BasicDao {

    ArrayList<Book> findBooks(Map<String, Object> paramMap, PageBounds pageBounds);

    ArrayList<Book> findByPrice(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice,  PageBounds pageBounds);

}
