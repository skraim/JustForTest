package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class ColectionsTest {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        col.add("agsfasg!");
        col.add("gflgk!");
        col.add("gcaasgl;asfasg!");
        col.add("aboipgsfasg!");
        col.add("aasdgsfasg!");
        col.add("adjhgjsfasg!");
        col.add("aersfasg!");
        System.out.println(col);
        System.out.println("====^1");
        col.stream()
                .forEach(System.out::print);
        System.out.println("====^2");
        for (String s : col) {
            System.out.print(s + " ");
        }
        System.out.println("====^3");
        Iterator it = col.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println("====^4");
        for (Object o : col.toArray()) {
            System.out.print(o+ " ");
        }
        System.out.println("====^5");
        for (String s : col.toArray(new String[0])) {
            System.out.print(s + " ");
        }
        System.out.println("====^6");
        col.forEach(System.out::print);
        System.out.println("====^7");
        col.forEach((s) -> System.out.print(s));
        System.out.println("====^8");
    }
}
