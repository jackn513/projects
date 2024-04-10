package org.example.music2.dao.CartItem;

import org.example.music2.model.CartItem;

import java.util.List;

public interface CartItemDao {

    CartItem getCartItemById(int cartItemId);

    CartItem getCartItemByProductIdAndUserId(int albumId, int customerId);
    List<CartItem> getCartItemsByUserId(int customerId);
    CartItem createCartItem(CartItem item);
    CartItem updateCartItem(CartItem item);
    int deleteCartItemById(int cartItemId);
    int deleteCartItemsByUserId(int customerId);
}
