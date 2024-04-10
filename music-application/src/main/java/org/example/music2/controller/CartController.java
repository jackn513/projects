package org.example.music2.controller;


import org.example.music2.CartService;
import org.example.music2.exception.DaoException;
import org.example.music2.model.Cart;
import org.example.music2.model.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/cart")
@PreAuthorize("isAuthenticated()")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get the user's cart
    @RequestMapping(path = "", method = RequestMethod.GET)
    public Cart get(Principal principal) {
        return cartService.getUserCart(principal);
    }

    // Add an item to the user's cart
    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public CartItem addProduct(@Valid @RequestBody CartItem item, Principal principal) {
        try {
            return cartService.addToCart(principal, item);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }

    // Remove an item from the user's cart
    @RequestMapping(path = "/items/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable int itemId, Principal principal) {
        try {
            cartService.removeFromCart(principal, itemId);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }

    // Clear the user's cart
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clear(Principal principal) {
        try {
            cartService.clearCart(principal);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }
}
