package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Specialties {
    private WebDriver driver;

    public Specialties(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By specialtiesText = By.cssSelector(".container-fluid>.container>h2");

    //----------Methods----------
    public String specialtiesText(){
        return driver.findElement(specialtiesText).getText();
    }
}