
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        case01();
    }

    public static void case01() {
        Account a = new Account("A");
        Account b = new Account("B");
        a.deposit(new BigDecimal("1000"));
        b.deposit(new BigDecimal("1000"));

        System.out.println(a.toString());
        System.out.println(b.toString());

        Transfer transAB = new Transfer(a, b, BigDecimal.TEN);
        Thread t = new Thread(transAB);
        t.start();

        System.out.println(a.toString());
        System.out.println(b.toString());

    }

    public static void case02() {
        Account a = new Account("A");
        Account b = new Account("B");
        a.deposit(new BigDecimal("1000"));
        b.deposit(new BigDecimal("1000"));

        System.out.println(a.toString());
        System.out.println(b.toString());

        Transfer transAB = new Transfer(a, b, BigDecimal.TEN);
        Transfer transBA = new Transfer(b, a, BigDecimal.TEN);

        Thread t1 = new Thread(transAB);        
        Thread t2 = new Thread(transBA);
        t1.start();
        t2.start();        
        
        System.out.println(a.toString());
        System.out.println(b.toString());
    }

}
