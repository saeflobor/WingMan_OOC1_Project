import javax.swing.*;

public class Food {
    private int itemNo;
    private String itemName;
    private int price;
    private int quantity;

    public Food(int itemNo, String itemName, int price, int quantity) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void buyFood(int q){

        quantity=quantity-q;
    }
}
