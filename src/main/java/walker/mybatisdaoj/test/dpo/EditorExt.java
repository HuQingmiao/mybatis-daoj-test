package walker.mybatisdaoj.test.dpo;

import walker.mybatisdaoj.test.common.BasicPo;

import java.util.Date;

public class EditorExt extends Editor {
    private static final long serialVersionUID = 1L;

    private Long bookId;
    private String bookTitle;
    private Double bookPrice;
    private java.util.Date bookPublishTime;

    public EditorExt() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookPublishTime() {
        return bookPublishTime;
    }

    public void setBookPublishTime(Date bookPublishTime) {
        this.bookPublishTime = bookPublishTime;
    }
}

