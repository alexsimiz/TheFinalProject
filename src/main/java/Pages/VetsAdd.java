package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VetsAdd {
    private WebDriver driver;

    public VetsAdd(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By newVetText = By.cssSelector(".container-fluid>.container>h2");
    private By fields = By.cssSelector(".form-horizontal.ng-untouched.ng-pristine.ng-invalid>.has-feedback");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By type = By.id("specialties");
    private By saveVetButton = By.cssSelector(".btn.btn-default[type=\"submit\"]");

    //----------Methods----------
    public String wNewVetText(){
        return driver.findElement(newVetText).getText();
    }
    public int numberOfFields(){
        List<WebElement> listOfFields = driver.findElements(fields);
        return listOfFields.size();
    }
    public void sendFirstName(String fakerName){
        driver.findElement(firstName).sendKeys(fakerName);
    }
    public void sendLastName(String fakerName){
        driver.findElement(lastName).sendKeys(fakerName);
    }
    public void selectType(String spec){
        Select select = new Select(driver.findElement(type));
        select.selectByVisibleText(spec);
    }
    public WebElement wSaveVetButton(){
        return driver.findElement(saveVetButton);
    }
}