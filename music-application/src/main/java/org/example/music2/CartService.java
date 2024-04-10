package org.example.music2;


import org.example.music2.dao.Album.AlbumDao;
import org.example.music2.dao.CartItem.CartItemDao;
import org.example.music2.dao.Users.UserDao;
import org.example.music2.model.Album;
import org.example.music2.model.Cart;
import org.example.music2.model.CartItem;
import org.example.music2.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.List;

@Component
public class CartService {
    private CartItemDao cartItemDao;
    private AlbumDao albumDao;
    private UserDao userDao;
    private TaxService taxService;

    public CartService(CartItemDao cartItemDao, AlbumDao albumDao, UserDao userDao, TaxService taxService) {
        this.cartItemDao = cartItemDao;
        this.albumDao = albumDao;
        this.userDao = userDao;
        this.taxService = taxService;
    }


    public Cart getUserCart(Principal principal) {
        User user = getUser(principal);
        int userId =  user.getId();

        // Get the list of items in the user's cart
        List<CartItem> items = cartItemDao.getCartItemsByUserId(userId);
        Cart cart = new Cart(items);

        // Get the list of Products
        List<Album> albums = albumDao.getProductsByUserId(userId);

        // Merge the Product data into the Cart Items
        for (CartItem item : items) {
            item.setAlbum(findProduct(albums, item.getAlbumId()));
        }

        // With all the items in the cart, now the subtotal (calculated in the getter) is accurate. Now
        // use an external tax table API to calculate the tax for this order.
        BigDecimal taxRate = taxService.getTaxRate(user.getStateCode());
        BigDecimal subtotal = cart.getItemSubtotal();
        BigDecimal tax = subtotal.multiply(taxRate).setScale(2, RoundingMode.UP);
        cart.setTax(tax);
        return cart;
    }

    public void clearCart(Principal principal) {
        int userId = getUserId(principal);
        cartItemDao.deleteCartItemsByUserId(userId);
    }

    private Album findProduct(List<Album> products, int productId) {
        for (Album album : products) {
            if (album.getAlbumId() == productId) {
                return album;
            }
        }
        return null;
    }

    private int getUserId(Principal principal) {
        return userDao.getUserByUsername(principal.getName()).getId();
    }

    private User getUser(Principal principal) {
        return userDao.getUserByUsername(principal.getName());
    }

    public CartItem addToCart(Principal principal, CartItem item) {
        // The only thing we need or use on a new item is product and quantity
        int userId = getUserId(principal);
        item.setCustomerId(userId);

        // See if it's in the cart
        CartItem existingItem = cartItemDao.getCartItemByProductIdAndUserId(item.getAlbumId(), userId);

        if (existingItem == null) {
            // Not in the cart yet -- add it
            return cartItemDao.createCartItem(item);
        } else {
            // It's in the cart, update the quantity
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            return cartItemDao.updateCartItem(existingItem);
        }
    }

    public void removeFromCart(Principal principal, int cartItemId) {
        cartItemDao.deleteCartItemById(cartItemId);
    }
}

