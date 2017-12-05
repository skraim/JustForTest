package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test3 {
    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();
        col.add(12);
        col.add(124);
        col.add(1456412);
        col.add(66412);
        col.add(3212);
        col.add(312);
        col.add(1112);
        System.out.println("=========1");
        System.out.println(col);
        System.out.println("=========2");
        for (Integer i : col) {
            System.out.print(i + " ");
        }
        System.out.println("=========3");
        for (Object o : col.toArray()) {
            System.out.print(o + " ");
        }
        System.out.println("=========4");
        for (Integer i : col.toArray(new Integer[0])) {
            System.out.print(i + " ");
        }
        System.out.println("=========5");
        col.stream()
                .forEach(System.out::print);
        System.out.println("=========6");
        Iterator it = col.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("=========7");
        col.forEach(AA::m);
    }


}

class AA {
    static void m(Object o) {
        System.out.println("A#m");
    }
}
