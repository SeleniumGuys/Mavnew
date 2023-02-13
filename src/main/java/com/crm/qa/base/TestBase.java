package com.crm.qa.base;

import com.crm.qa.util.Testutil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop; // Global Variable


    // Declaring Constructor for base class
    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


    //This will launch the broswer
    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\singh\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(browserName.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            //driver.get("https://opensource-demo.orangehrmlive.com/");
            driver = new EdgeDriver();
        }
        //System.out.println("Invoked");

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
         // these time is coming from utils class, which is defined for this purpose.

        //driver.get("https://opensource-demo.orangehrmlive.com/");

        //System.out.println("2nvoked");
    }


}




