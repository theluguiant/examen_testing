package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomer {

    WebDriver driver; //objeto driver para la pantalla    

    //Elementos formulario
    By customerDelete = By.linkText("Delete Customer");
    By idCustomer = By.name("cusid");
    By submitButton = By.name("AccSubmit");

    //Constructor que recibe el objeto driver
    public DeleteCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public void setCustomerId(String strCustomerId) {
        driver.findElement(idCustomer).sendKeys(strCustomerId);
    }
    
   public void clickDeleteCustomer() {
        driver.findElement(customerDelete).click();
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strCustomerId
     * @return
     */
    //metodo que se usa en todos los casos de pruebas donde se necesite el login
    public void DeleteCustomerClass(String strCustomerId) {

        //se crea comentario para evidenciar un conflicto en los archivos
        this.clickDeleteCustomer();
        this.setCustomerId(strCustomerId);
        this.clickSubmit();
    }
}
