package collections;

public class Test2 {

    public static void main(String[] args) {
        //G g = "asdf"::concat;
        G g = (s, s2) -> {
            System.out.println(s);
        };
        //String res = g.m("ASDF");
        //String res2 = g.m("ASasdaDF");
        //System.out.println(res);
        //System.out.println(res2);
    }
}

interface G {
//    void m(String s);
    void m2(String s, String s2);

    @Override
    boolean equals(Object obj);
}
