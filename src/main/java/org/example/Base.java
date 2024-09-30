package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Base {
    public static AndroidDriver capabilities(String appName) throws IOException {

        AndroidDriver driver;

        //System.getProperty("user.dir");

        //FileInputStream fi = new FileInputStream("C:\\Users\\koush\\IdeaProjects\\TestAppDemo\\src\\main\\java\\global.properties");
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
        Properties prop = new Properties();
        prop.load(fi);
        String myAppName = prop.get(appName).toString();
        String deviceName = prop.get("device").toString();

        File appDir = new File("src/apps/");
        File app = new File(appDir,myAppName);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName",deviceName);
        caps.setCapability("appium:app",app.getAbsolutePath());
        //caps.setCapability("platformVersion","9.0");
        caps.setCapability("appium:automationName","UiAutomator2");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),caps);

        return driver;



    }
}
