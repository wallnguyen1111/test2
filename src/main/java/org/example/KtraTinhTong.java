package org.example;

public class KtraTinhTong {
    public Integer tinhTong(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Number phai be hon hoac bang 10 va lon hon 100");
        }

        if (number % 2 == 0) {
            throw new IllegalArgumentException("Number phai la so le");
        }
        Integer sum = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
