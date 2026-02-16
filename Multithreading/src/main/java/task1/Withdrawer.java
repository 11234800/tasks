package task1;

public class Withdrawer extends Thread {
    private BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                account.withdraw(150);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
