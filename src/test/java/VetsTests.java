import Utils.DatabaseInteraction;
import Utils.FakerGenerator;
import Pages.*;
import TestsCofing.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class VetsTests extends BaseTests {
    private VetsAdd vetsAdd;
    private Vets vets;

    @BeforeMethod()
    public void beforeMethod() {
        driver.get(properties.getProperty("newVetPage"));
        vetsAdd = new VetsAdd(driver);
        vets = new Vets(driver);
    }

    @Test
    public void addNewVet() {
        FakerGenerator fakerGenerator = new FakerGenerator();
        DatabaseInteraction db = new DatabaseInteraction();

        String firstName = fakerGenerator.getFirstName();
        String lastName = fakerGenerator.getLastName();
        String fullName = firstName + " " + lastName;
        String specialties = "dentistry";

        vetsAdd.sendFirstName(firstName);
        vetsAdd.sendLastName(lastName);
        vetsAdd.selectType(specialties);
        vetsAdd.wSaveVetButton().click();

        Assert.assertEquals(vets.lastFullName(), fullName);
        Assert.assertEquals(vets.lastSpecialties(), specialties);

        ArrayList<String> dbListOfVets = db.databaseQuery(properties.getProperty("database"),
                properties.getProperty("user"), properties.getProperty("password"),
                "select * from vets");

        boolean verifyVetAdded = false;
        for(String verifyOwner : dbListOfVets){
            if(verifyOwner.contains(fullName)){
                verifyVetAdded = true;
            }
        }

        Assert.assertTrue(verifyVetAdded);
    }
}
