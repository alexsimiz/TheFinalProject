package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OwnersAdd {
    private WebDriver driver;

    public OwnersAdd(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By newOwnerText = By.cssSelector(".container-fluid>.container.xd-container>h2");
    private By fields = By.cssSelector(".form-horizontal>.has-feedback");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By address = By.id("address");
    private By city = By.id("city");
    private By phone = By.id("telephone");
    private By addOwnerButton = By.cssSelector(".btn.btn-default[type=\"submit\"]");

    //----------Methods----------
    public String newOwnerText(){
        return driver.findElement(newOwnerText).getText();
    }

    public int numberOfFields(){
        List<WebElement> listOfFields = driver.findElements(fields);
        return listOfFields.size();
//        return driver.findElement(fields);
    }

    public void sendFirstName(String fakerName){
        driver.findElement(firstName).sendKeys(fakerName);
    }

    public void sendLastName(String fakerName){
        driver.findElement(lastName).sendKeys(fakerName);
    }

    public void sendAddress(String fakerAddress){
        driver.findElement(address).sendKeys(fakerAddress);
    }

    public void sendCity(String fakerCity){
        driver.findElement(city).sendKeys(fakerCity);
    }

    public void sendPhone(String fakerPhone){
        driver.findElement(phone).sendKeys(fakerPhone);
    }

    public WebElement wAddOwnerButton(){
        return driver.findElement(addOwnerButton);
    }
}