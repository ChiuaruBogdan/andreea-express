package org.fasttrackit.andreeaexpress.web;

import org.fasttrackit.andreeaexpress.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts/update/count")
public class CartUpdateCountController {

    private final CartService cartService;

    @Autowired
    public CartUpdateCountController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/cartId/itemId/count")
    public ResponseEntity updateCart(@PathVariable("cartId") long id,
                                     @PathVariable("itemId") long itemId,
                                     @PathVariable("count") int count) {
        cartService.updateCartCount(id, itemId, count);
        return new ResponseEntity(HttpStatus.OK);
    }
}
