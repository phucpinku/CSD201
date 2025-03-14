package lab7;

public class Student {

    String name;
    int age;
    double mark;

    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Mark: " + mark + ")";
    }
}
