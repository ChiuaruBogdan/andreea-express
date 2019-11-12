package org.fasttrackit.andreeaexpress.web;

import org.fasttrackit.andreeaexpress.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("carts/remove")
@RestController
public class CartRemoverController {

        private final CartService cartService;

        @Autowired
        public CartRemoverController(CartService cartService) {
            this.cartService = cartService;
        }

        @DeleteMapping("/{id}/{itemId}")
        public ResponseEntity removeProductFromCart(@PathVariable("id") long id, @PathVariable("itemId") long itemId) {
            cartService.deleteProductFromCart(id, itemId);
            return new ResponseEntity(HttpStatus.OK);
        }

}
