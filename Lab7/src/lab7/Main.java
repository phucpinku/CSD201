/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         HashTable hashTable = new HashTable();

        hashTable.insert(new Student("A5", 20, 85.5));
        hashTable.insert(new Student("A2", 21, 90.0));
        hashTable.insert(new Student("A3", 19, 78.5));
        hashTable.insert(new Student("B5", 22, 88.0));
        hashTable.insert(new Student("A9", 23, 92.0));
        hashTable.insert(new Student("B2", 20, 80.0));
        hashTable.insert(new Student("B9", 24, 95.0));
        hashTable.insert(new Student("C2", 21, 87.5));

        hashTable.display();
    }
    
}
