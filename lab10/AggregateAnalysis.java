public class AggregateAnalysis {
    public static void main(String[] args) {
        int n = 10; // n үйлдэл
        int totalCost = 0; // Нийт өртөг
        int logValue = 1; // Хоёрын зэрэгтэй тоонуудын хамгийн бага утга

        // i = 1 to n дотор бүх үйлдлийг гүйцэтгэж, өртөгийг тооцно
        for (int i = 1; i <= n; i++) {
            if (i == logValue) {
                totalCost += i; // Хоёрын зэрэгтэй тооны үед өртөг нь i байдаг
                logValue *= 2; // Дараагийн хоёрын зэрэгтэй тоо
            } else {
                totalCost += 1; // Бусад тохиолдолд өртөг нь 1 байна
            }
        }

        // Нийт өртөг
        System.out.println("Total cost for " + n + " operations: " + totalCost);

        // Нэгжийн өртөг
        double amortizedCost = (double) totalCost / n;
        System.out.println("Amortized cost per operation: " + amortizedCost);
    }
}
