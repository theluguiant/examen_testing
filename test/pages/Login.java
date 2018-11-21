package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    
    WebDriver driver; //objeto driver para la pantalla
    
    //Elementos de la pantalla
    By titleText = By.className("barone");
    By userName = By.name("uid");
    By password = By.name("password");
    By login = By.name("btnLogin");

    //Constructor que recibe el objeto driver
    public Login(WebDriver driver){

        this.driver = driver;
    }
    
     //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
         driver.findElement(password).sendKeys(strPassword);
    }
    
    //Click on login button
    public void clickLogin(){
            driver.findElement(login).click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
     return    driver.findElement(titleText).getText();
    }
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    //metodo que se usa en todos los casos de pruebas donde se necesite el login
    public void login(String strUserName,String strPasword){
        
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();        
    }

}

