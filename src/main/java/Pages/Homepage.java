package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    private WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By welcomeImagePets = By.cssSelector(".img-responsive");
    private By welcomeText = By.cssSelector("app-root>app-welcome>h1");

    //----------Methods----------
    public WebElement wWelcomeImagePets() {
        return driver.findElement(welcomeImagePets);
    }

    public WebElement wWelcomeText() {
        return driver.findElement(welcomeText);
    }
}
