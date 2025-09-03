package walker.mybatisdaoj.test.dpo; 

import walker.mybatisdaoj.test.common.BasicPo; 

public class BookEditor extends BasicPo {
    private static final long serialVersionUID = 1L;

    public static final String $TABLE_NAME = "BOOK_EDITOR";

    public static final String $ID = "id";
    public static final String $BOOK_ID = "bookId";
    public static final String $EDITOR_ID = "editorId";

    private Long id;
    private Long bookId;
    private Long editorId;

    public BookEditor () {
    }

    public Long getId() {
        return id;
   }

    public void setId(Long id) {
        this.id = id;
   }

    public Long getBookId() {
        return bookId;
   }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
   }

    public Long getEditorId() {
        return editorId;
   }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
   }

}

