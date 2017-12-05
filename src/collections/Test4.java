package collections;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();

        map.put(new A(1), 1);
        map.put(new A(2), 2);
        map.put(new A(3), 3);

        System.out.println(map);
    }

}

class A {
    int x;
    public String toString() { return "A(" + x + ")"; }
    public A(int x) { this.x = x; }
    public int hashCode() { return 0; }
    public boolean equals(Object obj) { return true; }

}
