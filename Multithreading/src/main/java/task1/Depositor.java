package task1;

public class Depositor extends  Thread {
    private BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
