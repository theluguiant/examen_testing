package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import pages.HomePage;
import pages.Login;
import pages.Car;

public class CarTest {

    //objetos de login
    static WebDriver driver;
    Login objLogin;
    HomePage objHomePage;
    Car objCar;
    

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //configura los tiempos implicitos(tiempo de espera para cargar)
    }

    @Before
    public void setUp() {
        driver.get("https://www.phptravels.net/admin");
    }
    
    @Test
    public void Create_car() {
        objLogin = new Login(driver);
        objCar = new Car(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        objLogin.login("admin@phptravels.com", "demoadmin");
        driver.get("https://www.phptravels.net/admin/cars");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        objCar.clicAddBtn();
        objCar.setCarName("testCars");
        objCar.selectOptionPassangers("6");
        objCar.selectOptionStatus("Disabled");
        objCar.clickTypeContent();
        objCar.clickTypeSelect();
        
        
    }

}
