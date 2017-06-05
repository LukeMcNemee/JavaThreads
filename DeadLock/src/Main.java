
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
        case02();
    }

    public static void case01() throws InterruptedException {
        Account a = new Account("A", 1);
        Account b = new Account("B", 2);
        a.deposit(new BigDecimal("1000"));
        b.deposit(new BigDecimal("1000"));

        System.out.println(a.toString());
        System.out.println(b.toString());

        Transfer transAB = new Transfer(a, b, BigDecimal.TEN);
        Thread t = new Thread(transAB);
        t.start();
        t.join();
        System.out.println(a.toString());
        System.out.println(b.toString());

    }

    public static void case02() throws InterruptedException {
        Account a = new Account("A", 1);
        Account b = new Account("B", 2);
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
        
        t1.join();
        t2.join();
        
        System.out.println(a.toString());
        System.out.println(b.toString());
    }

}
