package sample;

import java.io.Serializable;

public class Item implements Serializable {
    private String name="null";
    private int q;





    public Item(String name, int q) {
        this.name = name;
        this.q = q;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return q;
    }

    public void setQuantity(int quantity) {
        this.q = quantity;
    }
}
