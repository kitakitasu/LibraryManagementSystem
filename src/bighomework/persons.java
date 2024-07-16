package bighomework;

public class persons<E,T,V> implements thans<E,T,V>{
    private String name;
    private String sex;
    private T age;
    private E born;

    public persons() {
    }
    public persons(String name, String sex, T age, E born) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public E getBorn() {
        return born;
    }

    public void setBorn(E born) {
        this.born = born;
    }

    public void proverb(V v){
        System.out.println(this.name+":"+v);
    }

    @Override
    public String toString() {
        return "persons{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", born=" + born ;
    }



    @Override
    public <E1, T1, V1> boolean than(persons<E1, T1, V1> p1, persons<E1, T1, V1> p2) {
        if(p1.age.equals(p2)) return true;
        return false;
    }
}
