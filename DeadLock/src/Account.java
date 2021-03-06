
import java.math.BigDecimal;
import java.util.Currency;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukemcnemee
 */
public class Account {

    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;
    private static int DECIMALS = 2;

    private String name;
    private BigDecimal balance;
    private int id;
    
    
    private Currency curr = Currency.getInstance("CZK");

    public Account(String name, int id) {
        this.name = name;
        balance = new BigDecimal("0");
        this.id = id;
        System.out.println("new account: " + name + " in " + curr.getCurrencyCode());
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        synchronized (this) {
            return "Account{" + "name = " + name + ", balance = " + balance + ' ' + curr.getSymbol() + ' ' + '}';
        }
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

}
