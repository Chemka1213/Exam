package exam;

public class MyThread1 extends Thread {

    private String name;

    private int priority;

    private boolean isAlive;



    public MyThread1(String name, int priority) {

        this.name = name;

        this.priority = priority;

        this.isAlive = true;

    }



    public void run() {

        System.out.println(name + " урсгал эхэллээ.");

        try {

            Thread.sleep(1000); // 1 секунд хүлээн зөвшөөрөх

        } catch (InterruptedException e) {

            System.out.println(name + " урсгал санах ойролцоо.");

        }

        System.out.println(name + " урсгал дууслаа.");

        isAlive = false;

    }

    public static void main(String[] args) {

        MyThread1[] threads = new MyThread1[5];

        for (int i = 0; i < threads.length; i++) {

            String name = "Урсгал " + (i+1);

            int priority = (int) (Math.random() * 10) + 1;

            threads[i] = new MyThread1(name, priority);

            threads[i].setPriority(priority); 

            threads[i].start();

        }



   

        int totalThreads = threads.length;

        int aliveThreads = totalThreads;

        for (MyThread1 thread : threads) {

            System.out.println(thread.name + "-н priority: " + thread.priority);

            if (!thread.isAlive) {

                aliveThreads--;

            }

        }

        System.out.println("Урсгалуудын нийт тоо: " + totalThreads);

        System.out.println("Идэвхитэй урсгалуудын тоо: " + aliveThreads);

    }

}

