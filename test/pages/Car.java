package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Car {

	WebDriver driver;
	By btnDashboard = By.linkText("Cars");
	By btnAdd = By.xpath("//*[@id=\"content\"]/div/form/button");
	By carName = By.name("carname");
	By textArea = By.name("cardesc");
	By passangers = By.name("passangers");
	By doors = By.name("doors");
	By carstatus = By.name("carstatus");
	By s2idAutogen21 = By.xpath("//*[@id=\"s2id_autogen21\"]");
	By cartype = By.xpath("//*[@id=\"select2-drop\"]/ul/li[3]");
	
	//*[@id="select2-drop"]/ul/li[3]

	
	public Car(WebDriver driver) {
        this.driver = driver;
    }
	
	public void clicAddBtn() {
		driver.findElement(btnAdd).click();
	}

	public void setBtnAdd(By btnAdd) {
		this.btnAdd = btnAdd;
	}

	public void setCarName(String strUserName) {
		driver.findElement(carName).sendKeys(strUserName);
	}
	
	public void setBtnDashboard(By btnDashboard) {
		this.btnDashboard = btnDashboard;
	}

	public void setTextArea(String strTextArea) {
		driver.findElement(textArea).sendKeys(strTextArea);
	}


	public void selectOptionPassangers(String option) {
	    Select selectField= new Select(driver.findElement(passangers));
        selectField.selectByVisibleText(option);
	}
	
	public void selectOptionDoors(String option) {
	    Select selectField= new Select(driver.findElement(doors));
        selectField.selectByVisibleText(option);
	}
	
	public void selectOptionStatus(String option) {
	    Select selectField= new Select(driver.findElement(carstatus));
        selectField.selectByVisibleText(option);
	}
	
	public void clickTypeContent() {
		driver.findElement(s2idAutogen21).click();
	}
	
	public void clickTypeSelect() {
		driver.findElement(cartype).click();
	}
	
}
