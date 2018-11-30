package com.cjf.demo;

public class Demo10_Integer_Equals {
    private static long count;
    private final long id = count++;

    @Override
    public String toString() {
        return "Demo10_Integer_Equals{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        char[] asd = {'1', '2', '3'};
        char[] bsd = asd;
        Integer a = new Integer(10);

        Integer b = new Integer(10);
        Integer c = 10;
        Integer d = Integer.valueOf(10);
        //  System.out.println(a+" "+b);
        System.out.println("a.equals(b)?  " + (a.equals(b)));
        System.out.println("a.hashCode: " + a.hashCode() + " b.hashCode:  " + b.hashCode());
        System.out.println("a==b?         " + (a.equals(b)));
        System.out.println("c.equals(d)?  " + (c.equals(d)));
        System.out.println("c==d?         " + (c.equals(d)));
        System.out.println(asd);
        Class t = Class.forName("com.cjf.demo.Demo10_Integer_Equals");
        Object s = t.newInstance();
        System.out.println(s);
        System.out.println();
    }
}
