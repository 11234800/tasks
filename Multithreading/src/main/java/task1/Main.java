package task1;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //myThread.start();

        Thread thread1 = new Thread(new MyRunnable());
        //thread1.start();

        SleepThread sleepThread = new SleepThread();
        //myThread.start();

        BankAccount account = new BankAccount();
        Depositor depositor = new Depositor(account);
        Withdrawer withdrawer = new Withdrawer(account);
        depositor.start();
        withdrawer.start();

        try {
            myThread.join();
            thread1.join();
            sleepThread.join();
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("all tasks finished");
    }
}