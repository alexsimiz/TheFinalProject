package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Header {
    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators----------
    private By navBar = By.cssSelector(".navbar.navbar-default");
    private By dropdownTabs = By.cssSelector(".dropdown.open>.dropdown-menu>li");
    private By homeTab = By.cssSelector(".nav>li:nth-child(1)>a");
    private By ownersTab = By.cssSelector(".dropdown:nth-child(2)>a");
    private By vetTab = By.cssSelector(".dropdown:nth-child(3)>a");
    private By petTypesTab = By.cssSelector(".nav.navbar-nav>li:nth-child(4)>a");
    private By specialtiesTab = By.cssSelector(".nav.navbar-nav>li:nth-child(5)>a");

    private By firstSubTab = By.cssSelector(".dropdown.open>.dropdown-menu>li:nth-child(1)>a");
    private By secondSubTab = By.cssSelector(".dropdown.open>.dropdown-menu>li:nth-child(2)>a");

    //----------Methods----------
    public WebElement wNavBar() {
        return driver.findElement(navBar);
    }

    public WebElement wHomeTab() {
        return driver.findElement(homeTab);
    }

    public WebElement wOwnersTab() {
        return driver.findElement(ownersTab);
    }

    public WebElement wVetTab() {
        return driver.findElement(vetTab);
    }

    public int numberOfSubTabs() {
        List<WebElement> listOfSubTabs = driver.findElements(dropdownTabs);
        return listOfSubTabs.size();
    }

    public WebElement wPetTypesTab() {
        return driver.findElement(petTypesTab);
    }

    public WebElement wSpecialtiesTab() {
        return driver.findElement(specialtiesTab);
    }

    public WebElement wFirstSubTab() {
        return driver.findElement(firstSubTab);
    }

    public WebElement wSecondSubTab() {
        return driver.findElement(secondSubTab);
    }
}