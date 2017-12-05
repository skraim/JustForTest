package Threads;

class ThreadTest extends Thread {
    public void run() {
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            try {Thread.sleep(800);}
            catch (Exception e) {e.printStackTrace();}
        }
    }
    public static void main(String[] args) throws 				InterruptedException {
        ThreadTest t = new ThreadTest(); t.start();
        Thread.sleep(1000);
        t.interrupt(); // через секунду будет выброс
        // исключения методом sleep если он
    }	// выполняется в данный момент
}

