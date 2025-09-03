package walker.mybatisdaoj.test.service;


import org.apache.ibatis.executor.BatchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import walker.mybatis.paginator.Order;
import walker.mybatis.paginator.PageBounds;
import walker.mybatis.paginator.PageList;
import walker.mybatisdaoj.test.dao.BookDao;
import walker.mybatisdaoj.test.dao.BookEditorDao;
import walker.mybatisdaoj.test.dao.EditorDao;
import walker.mybatisdaoj.test.dpo.Book;
import walker.mybatisdaoj.test.dpo.BookEditor;
import walker.mybatisdaoj.test.dpo.Editor;
import walker.mybatisdaoj.test.dpo.EditorExt;


import java.util.*;

/**
 * @author HuQingmiao
 */

@Service
@Transactional
public class SampleService {
    protected static Logger log = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    private BookDao bookDao;

    @Autowired
    private EditorDao editorDao;

    @Autowired
    private BookEditorDao bookEditorDao;


    /**
     * 增加一本书;
     */
    public void saveOne() {
        log.info("saveOne() >>");

        Book book = new Book();
        book.setBookId(Long.valueOf(101));
        book.setTitle(new String("三国演义"));
        book.setPrice(Double.valueOf(2930.0));
        book.setPublishTime(new Date());

        int cnt = bookDao.save(book);
        log.info(">>cnt: {}\n", cnt);

        log.warn(">>>>>>>>>>>>>>>> " + book.getBookId());
    }


    public void saveMany() {
        log.info("saveMany() >>");

        Book[] BookArray = new Book[3];

        BookArray[0] = new Book();
        BookArray[0].setBookId(Long.valueOf(201));
        BookArray[0].setTitle(new String("UNIX-上册"));
        BookArray[0].setPrice(Double.valueOf(31.0));
        BookArray[0].setPublishTime(new Date());

        BookArray[1] = new Book();
        BookArray[1].setBookId(Long.valueOf(202));
        BookArray[1].setTitle(new String("UNIX-中册"));
        BookArray[1].setPrice(Double.valueOf(52.0));
        BookArray[1].setPublishTime(new Date());

        BookArray[2] = new Book();
        BookArray[2].setBookId(Long.valueOf(203));
        BookArray[2].setTitle(new String("UNIX-下册"));
        BookArray[2].setPrice(Double.valueOf(53.0));
        BookArray[2].setPublishTime(new Date());

        int cnt = bookDao.saveBatch(Arrays.asList(BookArray));
        log.info(">>cnt: {}\n", cnt);
    }


    public void updateOne() {
        log.info("updateOne() >>");

        Book book = (Book) bookDao.findByPK(101L);
        book.setTitle(new String("八国演义(第二版)"));
        book.setPrice(Double.valueOf(39.9));

        int cnt = bookDao.update(book);
        log.info(">>cnt: {}\n", cnt);
    }


    public void updateMany() {
        log.info("updateMany() >>");

        //找出50元以上的书，然后打6折
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("minPrice", Float.valueOf(50));
        List<Book> bookList = bookDao.findBooks(paramMap, new PageBounds());

        for (Book book : bookList) {
            book.setTitle(book.getTitle() + "(折扣版)");
            book.setPrice(Double.valueOf(49.9));
        }

        int cnt = bookDao.updateBatch(bookList);
        log.info(">>cnt: {}\n", cnt);
    }


    public void deleteAll() {
        log.info("deleteAll() >>");

        int cnt = bookDao.deleteAll();
        log.info(">>cnt: {}\n", cnt);
    }

    public void deleteOne() {
        log.info("deleteOne() >>");

        int cnt = bookDao.deleteByPK(Long.valueOf(101));
        log.info(">>cnt: {}\n", cnt);
    }


    public void deleleteMany() {
        log.info("deleleteMany() >>");

        //删除价格在49元以上的书
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("price", Float.valueOf(49.0f));
        List<Book> bookList = bookDao.find(paramMap, new PageBounds());

        int cnt = bookDao.deleteBatch(bookList);
        log.info(">>cnt: {}\n", cnt);
    }


    public void findOne() {
        log.info("findOne() >>");

        Book book = (Book) bookDao.findByPK(101L);
        if (book != null) {
            log.info(">>book: {} \n", book.toString());
        } else {
            log.info("Not found! \n");
        }
    }



    public void findAll() {
        log.info("findAll() >>");

        // 设置查询条件(可以为空)
        HashMap<String, Object> paramMap = new HashMap<String, Object>();

        // 设置排序规则(非必须)
        String sortString = Book.$TITLE + ".asc" + ", " + Book.$PRICE + ".desc";
        PageBounds pageBounds = new PageBounds(Order.formString(sortString));

        // 执行查询
        List<Book> bookList = bookDao.find(paramMap, pageBounds);

        for (Book book : bookList) {
            log.info(book.getBookId() + " " + book.getTitle() + " " + book.getPrice());
        }
        log.info("\n");
    }

    public void findByPks() {
        log.info("findByPks() >>");

        HashSet<Long> idSets = new HashSet<Long>();
        idSets.add(Long.valueOf(101));
        idSets.add(Long.valueOf(201));
        idSets.add(Long.valueOf(202));
        idSets.add(Long.valueOf(203));
        List<Book> result = bookDao.findByPKs(idSets);

        for (Book book : result) {
            log.info(book.getBookId() + " " + book.getTitle() + " " + book.getPrice());
        }
        log.info("\n");
    }


    public void findBooks() {
        log.info("findBooks() >>");

        // 设置查询条件
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("title", "%UNIX%");

        int offset = 1; //起始行号
        int rowcnt = 3; //获取行数
        String sortString = Book.$TITLE + ".asc" + ", " + Book.$PRICE + ".desc";//如果想排序的话,以逗号分隔多项排 序列
        PageBounds pageBounds = new PageBounds(offset, rowcnt, Order.formString(sortString));
        List<Book> bookList = bookDao.findBooks(paramMap, pageBounds);

        // 执行查询
        PageList<Book> pageList = (PageList<Book>) bookList;//获得结果集条总数

        log.info("totalCount: " + pageList.getTotalCount());
        for (Book book : bookList) {
            log.info(book.getBookId() + " " + book.getTitle() + " " + book.getPrice());
        }
        log.info("\n");
    }


    public void findByPrice() {
        log.info("findByPrice() >>");

        // 设置查询条件
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("title", "%UNIX%");

        int offset = 1; //起始行号
        int rowcnt = 3; //获取行数
        String sortString = Book.$TITLE + ".asc" + ", " + Book.$PRICE + ".desc";//如果想排序的话,以逗号分隔多项排 序列
        PageBounds pageBounds = new PageBounds(offset, rowcnt, Order.formString(sortString));
        List<Book> bookList = bookDao.findByPrice(10.0, 10000.0, pageBounds);

        // 执行查询
        PageList<Book> pageList = (PageList<Book>) bookList;//获得结果集条总数

        log.info("totalCount: " + pageList.getTotalCount());
        for (Book book : bookList) {
            log.info(book.getBookId() + " " + book.getTitle() + " " + book.getPrice());
        }
        log.info("\n");
    }


    public void saveEditorAndRelation() {
        log.info("saveEditorAndRelation() >>");

        int cnt = editorDao.deleteAll();
        log.info(">>cnt: " + cnt);

        cnt = bookEditorDao.deleteAll();
        log.info(">>cnt: " + cnt);

        List<Editor> editorList = new ArrayList<Editor>();
        Editor editor1 = new Editor();
        editor1.setEditorId(Long.valueOf(22));
        editor1.setName("徐静蕾");
        editor1.setSex("F");
        editorList.add(editor1);

        Editor editor2 = new Editor();
        editor2.setEditorId(Long.valueOf(33));
        editor2.setName("张德芬");
        editor2.setSex("F");
        editorList.add(editor2);
        editorDao.saveBatch(editorList);

        List<BookEditor> bookEditorList = new ArrayList<BookEditor>();
        BookEditor be1 = new BookEditor();
        be1.setBookId(Long.valueOf(201));
        be1.setEditorId(Long.valueOf(22));
        bookEditorList.add(be1);

        BookEditor be2 = new BookEditor();
        be2.setBookId(Long.valueOf(202));
        be2.setEditorId(Long.valueOf(22));
        bookEditorList.add(be2);

        BookEditor be3 = new BookEditor();
        be3.setBookId(Long.valueOf(101));
        be3.setEditorId(Long.valueOf(33));
        bookEditorList.add(be3);

        bookEditorDao.saveBatch(bookEditorList);
        log.info("\n");
    }


    /*
     * 关联查询
     */
    public void findEditorAndBook() {
        log.info("findEditorAndBook() >>");

        // 设置查询条件
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("editorName", "徐静蕾");

        // 分页及排序
        int offset = 0; //起始行号
        int count = 2;  //获取条数
        String sortString = Book.$TITLE + ".asc" + ", " + Book.$PRICE + ".desc";
        PageBounds pageBounds = new PageBounds(offset, count, Order.formString(sortString));

        // 执行查询
        List<EditorExt> result = editorDao.findEditorAndBooks(paramMap, pageBounds);

        for (EditorExt item : result) {
            log.info(item.getName() + "(" + item.getSex() + "): " + item.getBookId() + " " + item.getBookTitle() + " " + item.getBookPrice());
        }
        log.info("\n");
    }

}