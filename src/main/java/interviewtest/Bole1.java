package interviewtest;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bole1 {

    // 5000那个月不收税
    public ArrayList<String> calcTax (ArrayList<Double> income) {
        ArrayList<String> res = new ArrayList<>();
        Double sum = 0D;
        Double pre = 0D;
        for (Double d : income){
            if (d < 5000D){
                res.add("0.00");
                sum += d;
                continue;
            }
            if (d > 5000D){
                if (sum + d - 5000< 36000D) {

                    Double a = (d - 5000D) * 0.03;
                    // 该月
                    BigDecimal b = new BigDecimal(a);
                    BigDecimal bigDecimal = b.setScale(2, RoundingMode.DOWN);
                    res.add(bigDecimal.toString());
                    sum += d - 5000;
                    pre += a;
                }else {
                    Double year = getYear(sum + d - 5000, pre);
                    BigDecimal b = new BigDecimal(year);
                    BigDecimal bigDecimal = b.setScale(2, RoundingMode.DOWN);
                    res.add(bigDecimal.toString());
                    sum += d - 5000;
                    pre += year;
                }
            }
        }
        return res;
    }


    // 返回改月的税务
    public Double getYear(Double sum, Double pre){
        Double res = 0D;
        if (sum > 36000D){
            res += 36000D * 0.03;
            if (sum <= 144000D){
                res += (sum - 36000D) * 0.1;
                return res - pre;
            }
        }

        if (sum > 144000){
            res += (144000 - 36000) * 0.1;
            if (sum < 300000){
                res += (sum - 1440000) * 0.2;
                return res - pre;
            }
        }

        if (sum > 300000){
            res += (300000 - 144000) * 0.2;
            if (sum <= 420000){
                res += (sum - 300000) * 0.25;
                return res - pre;
            }
        }

        if (sum > 420000){
            res += (420000 - 300000) * 0.25;
            if (sum <= 660000){
                res +=(sum - 420000) * 0.3;
                return res - pre;
            }
        }

        if (sum > 660000){
            res += (660000 - 420000) * 0.3;
            if (sum <= 960000){
                res += (sum - (660000)) * 0.35;
                return res - pre;
            }
        }

        if (sum > 960000){
            res += (960000 - 660000) * 0.35;
            res += (sum - 960000) * 0.45;
            return res - pre;
        }
        return 0D;
    }

    public static void main(String[] args) {
        Bole1 b = new Bole1();
        ArrayList<Double> a = new ArrayList<>();
        Double bl = 10000D;
        for (int i = 0; i < 12; i++){
            a.add(bl);
        }
        ArrayList<String> arrayList = b.calcTax(a);
        for(String av : arrayList){
            System.out.println(av);
        }

    }




}
