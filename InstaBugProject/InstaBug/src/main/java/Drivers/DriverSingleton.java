package Drivers;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String browserType) {
        switch (browserType)
        {
            case "CHROME":{
                try {
                    System.out.println("Quitting Chrome incase is already opened ");
                    driver.quit();
                }
                catch (Exception ignored) {
                }
                System.out.println("Opening Chrome ");
                driver = new ChromeDriver();
                break;
            }
            case "FIREFOX":{
                try {
                    System.out.println("Quitting firefox incase is already opened ");
                    driver.quit();
                }
                catch (Exception ignored) {
                }
                System.out.println("Opening firefox ...");
                driver = new FirefoxDriver();
                break;
            }
            case "EDGE":{
                try {
                    System.out.println("Quitting edge incase is already opened ");
                    driver.quit();
                }
                catch (Exception ignored) {
                }
                try {
                    driver = new EdgeDriver();
                } catch (SessionNotCreatedException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }

    }




}
