package leetcode.medium;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public void fun(String a, String[] ac){
        System.out.println(ac);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       Integer a = new Integer(20);
       Integer b = new Integer(20);
       Integer c = 200;
       Integer num4 = Integer.valueOf(20);
       Integer num5 = Integer.valueOf(20);
//       System.out.println(num5 == num4);
    }
}
