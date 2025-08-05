import logging

logging.basicConfig(level=logging.INFO)

TAX_RATE = 0.18
DISCOUNT_THRESHOLD = 500
DISCOUNT_RATE = 0.10


def parse_item(raw_item):
    """Convert string like 'apple:2:50' to dict {'name': 'apple', 'quantity': 2, 'price': 50}"""
    logging.debug(f"Parsing item: {raw_item}")
    parts = raw_item.split(":")
    return {
        "name": parts[0],
        "quantity": int(parts[1]),
        "price": float(parts[2])
    }


def calculate_total(cart_items):
    subtotal = 0
    for item in cart_items:
        item_total = item["quantity"] * item["price"]
        logging.info(f"{item['name']} - Qty: {item['quantity']}, Unit Price: {item['price']}, Total: {item_total}")
        subtotal += item_total
    return subtotal


def apply_discount(subtotal):
    if subtotal > DISCOUNT_THRESHOLD:
        discount = subtotal * DISCOUNT_RATE
        logging.info(f"Discount applied: {discount}")
        return subtotal - discount
    return subtotal


def apply_tax(total):
    tax = total * TAX_RATE
    logging.info(f"Tax applied: {tax}")
    return total + tax


def checkout(raw_cart):
    cart = []
    for raw in raw_cart:
        item = parse_item(raw)
        cart.append(item)

    subtotal = calculate_total(cart)
    after_discount = apply_discount(subtotal)
    final_total = apply_tax(after_discount)

    return final_total


def main():
    # Item format: "name:quantity:price"
    raw_cart = [
        "apple:2:50",
        "banana:5:20",
        "milk:1:120"
    ]

    logging.info("Starting checkout...")
    total = checkout(raw_cart)
    logging.info(f"Final total to pay: ₹{total:.2f}")



main()