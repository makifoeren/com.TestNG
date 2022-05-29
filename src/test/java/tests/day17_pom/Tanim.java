package tests.day17_pom;

public class Tanim {
    /*
    1--POM Page Object Model Java OOP konsept ile Selenium u birlestiren testlerimizi daha hizli daha anlasilir reusable ve
    easy maintable ozellikllerine sahip popular bir framework dizay modelidir.

    2-- Temel hedef test methodlarinda elle girilen hic bir deger olmamasidir(url,locate veya testdata )
    3-- Temelde projemizde 3 package bulunur
            1. Pages: locate islemleri ve reusable login method u gibi temel methodlar
            2.utilities: projemiz icin gerekli ekstra kaynaklar alet edevat Driver,TestBase, ConfigurationReader classlari
            3. Test: butun testlerimiz,data girisi yapmayacagiz

    4--Pages paketinde kullandigimiz herbir page icin ayri bir page class i olur.Eger test ettigimiz page de cok
    fazla ozellikler varsa her bir epik icin ayri page class i olusturabiliriz.
    Her page sayfasi olusturduguzdailk yapmamiz gereken bir parametresiz constractor olusturmak
    constructor icn de pageFactory class indan initElemnt() kullanip Driver class indaki getDriver() in getirecegi driver i
    bu class (this) da gecerli olacagini tanimlamaktir.
    page sayfalarinda bugune kadar locate icin kullandigimiz findElement veya findElemnts yerine @FindBy notasyxonu kullanilir.
    Degisen ikinci satir olur. Public WebElement a Elementi olurken digerinde public
    List<WebElemnt> aElemntleriListesi

    5--Driver class i olusturup bize driver dondurecek getDriver() ve driveri kapatacak closeDriver() methodlarina olusturduj
    Bu iki methoda heryerden kolayca erisebilmek icin methidlar static olarak tanimladik

    POM da java nin altindaki 3 package
    1-- pages
    2-- Test pages olusturup gunleri onun icine alacagiz
    3-- utilities pages gerekli alet
        TeseBase var birde Driver olusturacaz

     */
}
