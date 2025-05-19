/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Item {
    private String name;
    private  int quantity;
    private int price;

    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = 0;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "("+name+","+quantity+","+price+")";
    }
}
