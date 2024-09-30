import io.appium.java_client.android.AndroidDriver;
import org.example.Base;

import java.io.IOException;

public class Test1 extends Base {

    public static void main(String[] args) throws IOException {
        AndroidDriver driver = capabilities("GeneralStoreApp");
        System.out.println(driver.getCapabilities());
    }



}
