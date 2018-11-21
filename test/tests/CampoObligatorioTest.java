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
import pages.CampoObligatorio;

public class CampoObligatorioTest {

    //objetos
    static WebDriver driver;
    
    //inicialización de los objetos
    Login objLogin = new Login(driver);
    HomePage objHomePage = new HomePage(driver); 
    CampoObligatorio objCampoObligatorio = new CampoObligatorio(driver); 
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //configura los tiempos implicitos(tiempo de espera para cargar)
    }
    
    @Before
    public void setUp() {
        driver.get("http://demo.guru99.com/V4/");
    }
    
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
//    
    @Test
    public void test_CampoObligatorio() {
        
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        objLogin.login("mgr123", "mgr!23");
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        objCampoObligatorio.CampoObligatorioClass("");
        String Validacion = objCampoObligatorio.getMensajeObl();
        Assert.assertFalse(objCampoObligatorio.getMensajeObl().toLowerCase().contains("Customer name must not be blank"));
    }
}
