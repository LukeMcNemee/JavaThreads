
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukemcnemee
 */
public class Transfer implements Runnable {

    Account from;
    Account to;
    BigDecimal amount;

    public Transfer(Account from, Account to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (from.getId() > to.getId()) {

            synchronized (from) {
                synchronized (to) {
                    to.deposit(amount);
                    from.withdraw(amount);
                }
            }
        } else {
            synchronized (to) {
                synchronized (from) {
                    to.deposit(amount);
                    from.withdraw(amount);
                }
            }
        }
    }

}
