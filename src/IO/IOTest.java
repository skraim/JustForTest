package IO;

import java.io.*;

public class IOTest implements FileFilter{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream(new File("test.txt"));
        fos.write((int) 'a');
        fos.flush();
        File file = new File("test2.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("asldk");
        fw.flush();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(new FileReader(new File("test2.txt")));
        String s = br.readLine();
        System.out.println(s);
        System.out.println(System.getProperty("file.encoding"));
        System.setProperty("file.encoding", "Cp866");
        System.out.println(System.getProperty("file.encoding"));
        System.out.println("asdфыв");
        System.out.println(file.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        file = new File("../");
        System.out.println(file.getAbsolutePath());
        ;
        System.out.println(file.getCanonicalPath());
        if (file.isDirectory()) {
            for (File d : file.listFiles()) {
                System.out.println(d);
            }
        } else {
            System.out.println("not a directory");
        }
        Dude d = new Dude(19, "kiril");
        Dude d2 = new Dude(119, "dima");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("dudes.txt")));
        oos.writeObject(d);
        oos.writeObject(d2);
        oos.flush();
        d = null;
        d2 = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("dudes.txt")));
        Object first = ois.readObject();
        Object second = ois.readObject();
        if (first instanceof Dude) {
            d = (Dude)first;
        } else System.out.println("error");
        if (second instanceof Dude) {
            d2 = (Dude)second;
        } else System.out.println("error");
        System.out.println(d.age + d.name);
        System.out.println(d2.age + d2.name);
    }

    @Override
    public boolean accept(File f) {
        return 'a' == f.getName().charAt(0);
    }
}

class Dude implements Serializable {
    int age;
    String name;

    public Dude(int age, String name) {
        this.name = name;
        this.age = age;
    }

}