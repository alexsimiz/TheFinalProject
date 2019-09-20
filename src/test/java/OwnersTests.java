import Utils.DatabaseInteraction;
import Utils.FakerGenerator;
import Pages.*;
import TestsCofing.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class OwnersTests extends BaseTests {
    private OwnersAdd ownersAdd;
    private Owners owners;

    @BeforeMethod()
    public void beforeMethod() {
        driver.get(properties.getProperty("newOwnerPage"));
        ownersAdd = new OwnersAdd(driver);
        owners = new Owners(driver);
    }

    @Test
    public void addNewOwner(){
        FakerGenerator fakerGenerator = new FakerGenerator();
        DatabaseInteraction db = new DatabaseInteraction();

        String firstName = fakerGenerator.getFirstName();
        String lastName = fakerGenerator.getLastName();
        String address = fakerGenerator.getAddress();
        String city = fakerGenerator.getCity();
        String phone = fakerGenerator.getPhone();
        String fullName = firstName + " " + lastName;

        ownersAdd.sendFirstName(firstName);
        ownersAdd.sendLastName(lastName);
        ownersAdd.sendAddress(address);
        ownersAdd.sendCity(city);
        ownersAdd.sendPhone(phone);
        ownersAdd.wAddOwnerButton().click();

        Assert.assertEquals(owners.lastFullName(), fullName);
        Assert.assertEquals(owners.lastAddress(), address);
        Assert.assertEquals(owners.lastCity(), city);
        Assert.assertEquals(owners.lastPhone(), phone);

        ArrayList<String> dbListOfOwners = db.databaseQuery(properties.getProperty("database"),
                properties.getProperty("user"), properties.getProperty("password"),
                "select * from owners");

        boolean verifyOwnerAdded = false;
        for(String verifyOwner : dbListOfOwners){
            if(verifyOwner.contains(fullName + " " + address + " " + city + " " + phone)){
                verifyOwnerAdded = true;
            }
        }

        Assert.assertTrue(verifyOwnerAdded);
    }
}