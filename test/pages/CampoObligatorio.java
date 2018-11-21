package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoObligatorio {

    WebDriver driver; //objeto driver para la pantalla
    By customerNew = By.linkText("New Customer");
    By nameCustomer = By.name("name");
    By gender = By.name("rad1");
    By mensaje = By.id("message");

    //Constructor que recibe el objeto driver
    public CampoObligatorio(WebDriver driver) {

        this.driver = driver;
    }

    public void setCustomerName(String strCustomerName) {
        driver.findElement(nameCustomer).sendKeys(strCustomerName);
    }
    
    public String getMensajeObl(){
       return driver.findElement(mensaje).getText();
    }

    public void clickNewCustomer() {
        driver.findElement(customerNew).click();
    }

    //Click on login button
    public void clickGender() {
        driver.findElement(gender).click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strCustomerName
     * @return
     */
    //metodo que se usa en todos los casos de pruebas donde se necesite el login
    public void CampoObligatorioClass(String strCustomerName) {

        this.clickNewCustomer();
        this.setCustomerName(strCustomerName);
        this.clickGender();
    }

}
