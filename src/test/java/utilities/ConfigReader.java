package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    Burasi ortaci gibi  properties i kullanip ihtiyaclari getircek
     */

    public static java.util.Properties properties;

    static{
        String dosyaYolu="configuration.properties"; // fis ten sonra buraya

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu); // fis olusturup dosya yolunu tanimlayaip try catch
            // fis dosya yolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); // fis in okudugu bilgileri propertis e yukledi(load)


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getProperty(String key){
        /*
        Test methodundan yolladigimiz string key degerini alip
        Properties class indan getProperty methodunu kullanarak
        bu key e ait value u bize getirdi

        String key  configuration.properties buraya gidip oradan bize string ifadesinin value degerini getirecek

        BURAYI YAPMAK ICIN STATIC BLOK DEVREYE GIRIP PROPERTIES DEVREYE GIRCEK ONUN ICIN 15. SATIR VE SONRASINI OLUSTURUYORUZ
         */
        return properties.getProperty(key);
    }
}
