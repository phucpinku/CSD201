package lab7;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<Student>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[26]; // Size 26 for A-Z
        for (int i = 0; i < 26; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String name) {
        return Character.toUpperCase(name.charAt(0)) - 'A';
    }

    public void insert(Student student) {
        int index = hashFunction(student.name);
        table[index].add(student);
    }

    public void display() {
        for (int i = 0; i < 26; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Student student : table[i]) {
                    System.out.print(student + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}
