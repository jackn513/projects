package org.example.music2.dao.CartItem;

import org.example.music2.exception.DaoException;
import org.example.music2.model.CartItem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCartItemDao implements CartItemDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCartItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CartItem getCartItemById(int cartItemId) {
        CartItem cartItem = null;
        String sql = "SELECT * FROM cart_item WHERE cart_item_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cartItemId);
            if (results.next()) {
                cartItem = mapRowToCartItem(results);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return cartItem;
    }

    @Override
    public CartItem getCartItemByProductIdAndUserId(int albumId, int customerId) {
        CartItem cartItem = null;
        String sql = "SELECT * FROM cart_item WHERE album_id = ? AND user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, albumId, customerId);
            if (results.next()) {
                cartItem = mapRowToCartItem(results);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return cartItem;
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int customerId) {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM cart_item WHERE user_id = ? ORDER BY cart_item_id";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            while (results.next()) {
                CartItem item = mapRowToCartItem(results);
                cartItems.add(item);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return cartItems;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        CartItem newCartItem = null;
        String sql = "INSERT INTO cart_item(user_id, album_id, quantity) VALUES (?, ?, ?) RETURNING cart_item_id";
        try {
            int newId = jdbcTemplate.queryForObject(sql, int.class, cartItem.getCustomerId(), cartItem.getAlbumId(), cartItem.getQuantity());
            newCartItem = getCartItemById(newId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newCartItem;

    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        CartItem updatedCartItem = null;
        // The only thing that can be updated is Quantity
        String sql = "UPDATE cart_item SET quantity = ? WHERE cart_item_id = ?";
        try {
            int rowAffected = jdbcTemplate.update(sql, cartItem.getQuantity(), cartItem.getCartItemId());
            if (rowAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            updatedCartItem = getCartItemById(cartItem.getCartItemId());
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedCartItem;
    }

    @Override
    public int deleteCartItemById(int cartItemId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM cart_item WHERE cart_item_id = ?";
        try {
            numberOfRows = jdbcTemplate.update(sql, cartItemId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    @Override
    public int deleteCartItemsByUserId(int userId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM cart_item WHERE user_id = ?";
        try {
            numberOfRows = jdbcTemplate.update(sql, userId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private CartItem mapRowToCartItem(SqlRowSet rowSet) {
        CartItem item = new CartItem();
        item.setCartItemId(rowSet.getInt("cart_item_id"));
        item.setCustomerId(rowSet.getInt("user_id"));
        item.setAlbumId(rowSet.getInt("album_id"));
        item.setQuantity(rowSet.getInt("quantity"));
        return item;
    }
}
