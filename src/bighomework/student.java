package bighomework;

public class student<E,T,V> extends persons<E,T,V> implements thans<E,T,V>{
    private String sno;
    private String grade;

    public student() {
    }

    public student(String sno, String grade) {
        this.sno = sno;
        this.grade = grade;
    }

    public student(String name, String sex, T age, E born, String sno, String grade) {
        super(name, sex, age, born);
        this.sno = sno;
        this.grade = grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()+", " +
                "grade='" + grade + '\'' +
                ", sno='" + sno + '\'' +
                "} " ;
    }
}
