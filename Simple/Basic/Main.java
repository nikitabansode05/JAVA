class SleepDemo extends Thread {

    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println(i);

            try {
                Thread.sleep(1000); // 1 second
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new SleepDemo().start();
    }
}
