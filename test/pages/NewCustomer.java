package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomer {

    WebDriver driver; //objeto driver para la pantalla    

    //Elementos formulario
    By titleText = By.className("barone");
    By customerNew = By.linkText("New Customer");
    By nameCustomer = By.name("name");
    By gender = By.name("rad1");
    By birthOfDate = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By numberMobile = By.name("telephoneno");
    By eMail = By.name("emailid");
    By password_ = By.name("password");
    By submitButton = By.name("sub");

    //Constructor que recibe el objeto driver
    public NewCustomer(WebDriver driver) {

        this.driver = driver;
    }

    public void setCustomerName(String strCustomerName) {
        driver.findElement(nameCustomer).sendKeys(strCustomerName);
    }

    public void setGender(String strGender) {
        driver.findElement(gender).sendKeys(strGender);
    }

    public void setDateofBirth(String strDateofBirth) {
        driver.findElement(birthOfDate).sendKeys(strDateofBirth);
    }

    public void setAddress(String strAddress) {
        driver.findElement(address).sendKeys(strAddress);
    }

    public void setCity(String strCity) {
        driver.findElement(city).sendKeys(strCity);
    }

    public void setState(String strState) {
        driver.findElement(state).sendKeys(strState);
    }

    public void setPIN(String strPIN) {
        driver.findElement(pin).sendKeys(strPIN);
    }

    public void setMobileNumber(String strMobileNumber) {
        driver.findElement(numberMobile).sendKeys(strMobileNumber);
    }

    public void setEmail(String strEmail) {
        driver.findElement(eMail).sendKeys(strEmail);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password_).sendKeys(strPassword);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    
    public void clickNewCustomer() {
        driver.findElement(customerNew).click();
    }
    
    public String getNewCustomerTitle(){
     return    driver.findElement(titleText).getText();
    }
    
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strCustomerName
     * @param strGender
     * @param strDateofBirth
     * @param strAddress
     * @param strCity
     * @param strState
     * @param strPIN
     * @param strMobileNumber
     * @param strEmail
     * @param strPassword      
     * @return
     */
    
    //metodo que se usa en todos los casos de pruebas donde se necesiten guardar datos
    public void NewCustomerClass(String strCustomerName,String strGender, String strDateofBirth, String strAddress,
                      String strCity, String strState, String strPIN, String strMobileNumber, String strEmail,String strPassword){

        this.clickNewCustomer();
        this.setCustomerName(strCustomerName);
        this.setGender(strGender);
        this.setDateofBirth(strDateofBirth);
        this.setAddress(strAddress);
        this.setCity(strCity);
        this.setState(strState);
        this.setPIN(strPIN);
        this.setMobileNumber(strMobileNumber);
        this.setEmail(strEmail);
        this.setPassword(strPassword);
        this.clickSubmit();
    }
}
