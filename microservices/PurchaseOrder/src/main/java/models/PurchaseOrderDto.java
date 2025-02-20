package models;

import java.util.List;

public record PurchaseOrderDto(List<CartItem> cartItems, String customerName) {
}
