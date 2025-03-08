

package lab6;


import java.util.Arrays;

class Employee implements Comparable<Employee> {
    String id;
    String name;
    int level;

    public Employee(String id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    @Override
    public int compareTo(Employee other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + level;
    }
}


