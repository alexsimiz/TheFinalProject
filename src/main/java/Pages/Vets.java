package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vets {
    private WebDriver driver;

    public Vets(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By vetText = By.cssSelector(".container-fluid>.container>h2");
    private By lastFullName = By.cssSelector("tr:nth-last-child(1)>td:nth-child(1)");
    private By lastSpecialties = By.cssSelector("tr:nth-last-child(1)>td:nth-child(2)");

    //----------Methods----------
    public String vetText(){
        return driver.findElement(vetText).getText();
    }

    public String lastFullName(){
        return driver.findElement(lastFullName).getText();
    }

    public String lastSpecialties(){
        return driver.findElement(lastSpecialties).getText();
    }
}