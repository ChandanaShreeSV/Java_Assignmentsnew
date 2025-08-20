public class Part3_StringDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;
        s1 = s1 + " World";
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        String a = "Java";
        String b = "Java";
        String c = new String("Java");
        String d = new String("Java");
        System.out.println("a==b: " + (a == b));
        System.out.println("c==d: " + (c == d));
        System.out.println("a.equals(c): " + a.equals(c));

        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < 1000; i++) str += "a";
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) + " ns");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
    }
}