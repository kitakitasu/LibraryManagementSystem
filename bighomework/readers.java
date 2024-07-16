package test7;

public class readers {
    private String readerlb;
    private String readername;
    private String readertnumber;
    private String readersex;
    private int sum;
    private int wg;

    public readers( String readerlb, String readername, String readertnumber, String readersex, int sum, int wg) {
        this.readerlb = readerlb;
        this.readername = readername;
        this.readertnumber = readertnumber;
        this.readersex = readersex;
        this.sum = sum;
        this.wg = wg;
    }

    public String getReaderlb() {
        return readerlb;
    }

    public void setReaderlb(String readerlb) {
        this.readerlb = readerlb;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getReadertnumber() {
        return readertnumber;
    }

    public void setReadertnumber(String readertnumber) {
        this.readertnumber = readertnumber;
    }

    public String getReadersex() {
        return readersex;
    }

    public void setReadersex(String readersex) {
        this.readersex = readersex;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getWg() {
        return wg;
    }

    public void setWg(int wg) {
        this.wg = wg;
    }
    @Override
    public String toString() {
        return "{" +
                "类别编号='" + readerlb + '\'' +
                ", 读者姓名=" + readername +'\'' +
                ", 读者电话='" + readertnumber + '\'' +
                ", 性别='" + readersex + '\'' +
                ", 借阅图书数量='" + sum + '\'' +
                ", 超时还书次数='" + wg + '\'' +
                '}';
    }
}
