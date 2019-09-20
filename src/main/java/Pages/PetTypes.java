package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetTypes {
    private WebDriver driver;

    public PetTypes(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    By petTyesText = By.cssSelector(".container-fluid>.container>h2");

    //----------Methods----------
    public String petTypesText(){
        return driver.findElement(petTyesText).getText();
    }
}