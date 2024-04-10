package org.example.music2.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    @Getter
    @Setter
    private BigDecimal tax;
    private List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<>();
        this.tax = new BigDecimal("0.00");
    }

    public Cart(List<CartItem> items){
        this();
        this.items = items;
    }

    public CartItem[] getItems(){
        CartItem result[] = new CartItem[items.size()];
        return items.toArray(result);
    }

    public BigDecimal getItemSubtotal() {
        BigDecimal subtotal = new BigDecimal("0.00");
        subtotal.setScale(2);

        for (CartItem item : items) {
            subtotal = subtotal.add(item.getAlbum().getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return subtotal;
    }

    public BigDecimal getTotal() {
        return getItemSubtotal().add(tax);
    }
}

