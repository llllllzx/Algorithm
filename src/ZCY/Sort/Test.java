package ZCY.Sort;

import java.util.Arrays;

/**
 * Created by zhaoxinliu on 2019/3/20
 */
public class Test {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "a";
        String e = d + "bc";
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.hashCode() == c.hashCode());
        System.out.println(a.hashCode() == e.hashCode());
    }
}