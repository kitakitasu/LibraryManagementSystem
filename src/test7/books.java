package test7;

import java.io.Serializable;

public class books implements Serializable {
    private String bookname;
    private String bookauthor;
    private String bookcbs;
    private int bookprice;
    private int sum;
    private int remain;

    public books(String bookname, String bookauthor, String bookcbs, int bookprice, int sum, int remain) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookcbs = bookcbs;
        this.bookprice = bookprice;
        this.sum = sum;
        this.remain = remain;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookcbs() {
        return bookcbs;
    }

    public void setBookcbs(String bookcbs) {
        this.bookcbs = bookcbs;
    }

    public int getBookprice() {
        return bookprice;
    }

    public void setBookprice(int bookprice) {
        this.bookprice = bookprice;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "{" +
                "图书名称='" + bookname + '\'' +
                ", 作者=" + bookauthor +'\'' +
                ", 出版社='" + bookcbs + '\'' +
                ", 价格='" + bookprice + '\'' +
                ", 总数量='" + sum + '\'' +
                ", 剩余数量='" + remain + '\'' +
                '}';
    }

}

