package walker.mybatisdaoj.test.dao;

import walker.mybatis.paginator.PageBounds;
import walker.mybatisdaoj.test.common.BasicDao;
import walker.mybatisdaoj.test.dpo.EditorExt;

import java.util.ArrayList;
import java.util.Map;

public interface EditorDao extends BasicDao {


    /**
     * 根据作者名称和标题查找该作者及其相应著作
     */
    ArrayList<EditorExt> findEditorAndBooks(Map<String, Object> param, PageBounds pageBounds);

}
