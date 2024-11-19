package example.multi;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //example0();
      //  example1();
        example2();
    }

    private static void example2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Федя"+": учись, студент!");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("кто не работает, тот ест");
            System.out.println(Thread.currentThread());
        }, "поток t1");

        Thread t2 = new Thread(() -> {
            System.out.println("Шурик"+": будем перевоспитывать");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("надо, Федя, надо!");
            System.out.println(Thread.currentThread());
        }, "поток t2");

        t1.start();
        t2.start();
        Thread.sleep(4500);
        t1.start();
        System.out.println("финиш");
    }

    private static void example1() {
        Thread w1= new Worker("Вася");
        w1.run();
        Thread w2= new Worker("Петя");
        w2.run();
        System.out.println("-----------------------");
        w1.start();
        w2.start();
    }

    private static void example0() throws InterruptedException {
        System.out.println(" текущий поток (основной) " + Thread.currentThread());
        Thread.sleep(5000);
        System.out.println("поспали и хватит");
    }
}

class Worker extends Thread{
    String name;

    public Worker(String name) {
        super("**"+name+"**");
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+": учись, студент!");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("кто не работает, тот ест");
        System.out.println(Thread.currentThread());
    }
}