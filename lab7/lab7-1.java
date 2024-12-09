import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;
    double ratio;

    // Item constructor
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;  // Value per unit weight
    }
}

public class FractionalKnapsack {

    // Fractional Knapsack function
    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Бараануудыг үнэ/жингийн харьцаагаар эрэмбэлэх
        Arrays.sort(items, Comparator.comparingDouble(item -> -item.ratio));

        double totalValue = 0.0;  // Үр дүнгийн үнэлгээ
        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            // Хэрвээ бараа бүгдийг нь оруулж чадахгүй бол хувааж оруулах
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0;  // Багтаамж дууссан
            }
        }
        return totalValue;
    }

    // Жишээ
    public static void main(String[] args) {
        // Жишээ бараанууд
        Item[] items = {
            new Item(60, 10),  // Бараа 1: үнэ=60, жин=10
            new Item(100, 20),  // Бараа 2: үнэ=100, жин=20
            new Item(120, 30)   // Бараа 3: үнэ=120, жин=30
        };
        int capacity = 50;  // Үүргэвчний багтаамж

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Максимум үнэлгээ: " + maxValue);
    }
}
