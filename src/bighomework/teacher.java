
package bighomework;

public class teacher<E, T, V> extends persons<E,T,V> implements thans<E,T,V>{
    private String tno;
    private T tage;

    public teacher() {
    }

    public teacher(String tno, T tage) {
        this.tno = tno;
        this.tage = tage;
    }

    public teacher(String name, String sex, T age, E born, String tno, T tage) {
        super(name, sex, age, born);
        this.tno = tno;
        this.tage = tage;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public T getTage() {
        return tage;
    }

    public void setTage(T tage) {
        this.tage = tage;
    }

    @Override
    public String toString() {
        return  super.toString()+", " +
                "tno='" + tno + '\'' +
                ", tage=" + tage +
                "} " ;
    }
}

