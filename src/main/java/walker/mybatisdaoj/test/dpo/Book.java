package walker.mybatisdaoj.test.dpo; 

import walker.mybatisdaoj.test.common.BasicPo; 

public class Book extends BasicPo {
    private static final long serialVersionUID = 1L;

    public static final String $TABLE_NAME = "BOOK";

    public static final String $BOOK_ID = "bookId";
    public static final String $TITLE = "title";
    public static final String $PRICE = "price";
    public static final String $PUBLISH_TIME = "publishTime";
    public static final String $BLOB_CONTENT = "blobContent";
    public static final String $ROW_VERSION = "rowVersion";

    private Long bookId;
    private String title;
    private Double price;
    private java.util.Date publishTime;
    private byte[] blobContent;
    private Long rowVersion;

    public Book () {
    }

    public Long getBookId() {
        return bookId;
   }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
   }

    public String getTitle() {
        return title;
   }

    public void setTitle(String title) {
        this.title = title;
   }

    public Double getPrice() {
        return price;
   }

    public void setPrice(Double price) {
        this.price = price;
   }

    public java.util.Date getPublishTime() {
        return publishTime;
   }

    public void setPublishTime(java.util.Date publishTime) {
        this.publishTime = publishTime;
   }

    public byte[] getBlobContent() {
        return blobContent;
   }

    public void setBlobContent(byte[] blobContent) {
        this.blobContent = blobContent;
   }

    public Long getRowVersion() {
        return rowVersion;
   }

    public void setRowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
   }

}

