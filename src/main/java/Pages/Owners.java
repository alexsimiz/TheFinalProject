package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Owners {
    private WebDriver driver;

    public Owners(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By ownersText = By.cssSelector(".container-fluid>.container>h2");
    private By lastFullName = By.cssSelector("tr:nth-last-child(1)>.ownerFullName");
    private By lastAddress = By.cssSelector("tr:nth-last-child(1)>td:nth-child(2)");
    private By lastCity = By.cssSelector("tr:nth-last-child(1)>td:nth-child(3)");
    private By lastPhone = By.cssSelector("tr:nth-last-child(1)>td:nth-child(4)");

    //----------Methods----------
    public String ownersText(){
        return driver.findElement(ownersText).getText();
    }
    public String lastFullName(){
        return driver.findElement(lastFullName).getText();
    }
    public String lastAddress(){
        return driver.findElement(lastAddress).getText();
    }
    public String lastCity(){
        return driver.findElement(lastCity).getText();
    }
    public String lastPhone(){
        return driver.findElement(lastPhone).getText();
    }

}