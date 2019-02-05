package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//se válida el texto que se presenta en el home
public class HomePage {

    WebDriver driver; //objeto driver 

    //Nota: Tener en cuenta que cuando utilizamos xpath o selector es mejor por práctica construirlos manualmente
    //ya que si lo obtenemos de la página, estos pueden cambiar en cualquier momento y dañarnos el script.
    By homePageUserName = By.xpath("//*[@id=\"social-sidebar-menu\"]/li/a/strong");

    //Constructr
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //captura del texto
    public String getHomePageDashboardUserName(){
        return driver.findElement(homePageUserName).getText();
    }
}
