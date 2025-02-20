package models;

import java.util.List;

public record PurchaseOrderDto(List<CartItem> cartItems, String customerName) {


    public float getTotalCost() {
        float totalCost = 0;
        for (CartItem cartItem : cartItems) {
            totalCost += cartItem.quantity()*cartItem.item().cost();
        }
        return totalCost;
    }
}
