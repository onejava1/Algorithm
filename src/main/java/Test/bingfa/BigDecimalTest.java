package Test.bingfa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        Double d = 1.626;
        BigDecimal b = new BigDecimal(d);
        // 精度不会影响原来的设计
        System.out.println(b.setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println(b.setScale(2, RoundingMode.HALF_DOWN).toString());
    }
}
