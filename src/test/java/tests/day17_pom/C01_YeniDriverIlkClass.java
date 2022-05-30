package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass  {

    // exstends artik gerek driver classindakini kullanacaz

    /*
    Driver classi ni yaptiktan sonra buraya geliyoru (2 )fakat surekli drivwr acip kapattigini enellemek icin tekrar
    driver classina gidip if yapmamiz gerekir
        Bugune kadar testbase classina extends ederek kullandigimiz driver yerine
        Driver class indan kullanacagamiz getDriver static methodunu kullanacagiz

        Driver.getDriver()
      */

    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");

        Driver.closeDriver();


        Driver.getDriver().get("https://www.bestbuy.com");

        Driver.getDriver().get("https://www.techproeducation.com");

        Driver.closeDriver();


    }
}
