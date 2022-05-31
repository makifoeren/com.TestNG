package tests.practice;

import org.testng.annotations.Test;

public class Q1_Priority {

     /*
      ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
      ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
      priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir.
      priority-> default sifirdir..
      enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina
        '(enabled = false)' fonksiyonunu kullaniriz.
     */


    @Test(priority = 3000, enabled = false)
    public void bTesti() {
        System.out.println("b");

    }

    @Test(priority = 2001)
    public void aTesti() {
        System.out.println("a");

    }

    @Test(priority = 2000)
    public void cTesti() {
        System.out.println("c");

    }
    /*
    c               c
    a              a
    b
ilk sonuc    (enabled = false)
     */

    @Test
    public void test01() {
        System.out.println("01");
    }

    @Test
    public void test03() {
        System.out.println("03");
    }

    @Test(enabled = false)
    public void test02() {
        System.out.println("02");
    }

    /*
    01
    03
    c
    a
 once rakamalr
     */
}
