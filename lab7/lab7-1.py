class Item:
    def __init__(self, value, weight):
        self.value = value
        self.weight = weight
        self.ratio = value / weight  # Value per unit weight

# Функц, үүргэвчинд оруулах бараануудын хамгийн их үнэлгээг олох
def fractional_knapsack(capacity, items):
    # Бараануудыг үнэ/жингийн харьцаагаар эрэмбэлнэ
    items.sort(key=lambda x: x.ratio, reverse=True)

    total_value = 0  # Үр дүнгийн үнэлгээ
    for item in items:
        if capacity <= 0:
            break
        # Хэрвээ бараа бүгдийг нь оруулж чадахгүй бол хувааж оруулах
        if item.weight <= capacity:
            total_value += item.value
            capacity -= item.weight
        else:
            total_value += item.value * (capacity / item.weight)
            capacity = 0  # Багтаамж дууссан

    return total_value

# Жишээ
if __name__ == "__main__":
    items = [
        Item(60, 10),  # Бараа 1: үнэ=60, жин=10
        Item(100, 20),  # Бараа 2: үнэ=100, жин=20
        Item(120, 30)   # Бараа 3: үнэ=120, жин=30
    ]
    capacity = 50  # Үүргэвчний багтаамж

    max_value = fractional_knapsack(capacity, items)
    print(f"Максимум үнэлгээ: {max_value}")
