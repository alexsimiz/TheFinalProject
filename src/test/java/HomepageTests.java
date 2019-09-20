import Pages.*;
import TestsCofing.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomepageTests extends BaseTests{
    private Header header;
    private Homepage homepage;
    private OwnersAdd ownersAdd;
    private VetsAdd vetsAdd;
    private Owners owners;
    private PetTypes petTypes;
    private Specialties specialties;
    private Vets vets;

    @BeforeMethod()
    public void beforeMethod() {
        driver.get(properties.getProperty("homepage"));
        homepage = new Homepage(driver);
        header = new Header(driver);
        ownersAdd = new OwnersAdd(driver);
        vetsAdd = new VetsAdd(driver);
        owners = new Owners(driver);
        petTypes = new PetTypes(driver);
        specialties = new Specialties(driver);
        vets = new Vets(driver);

    }

    @Test
    public void homepage(){
        logger.info("Starting homepage test");
        Assert.assertTrue(header.wNavBar().isDisplayed());
        Assert.assertTrue(homepage.wWelcomeImagePets().isDisplayed());
        Assert.assertEquals(homepage.wWelcomeText().getText(), "Welcome to Petclinic");
        logger.info("Ending homepage test");
    }

    @Test
    public void clickHomeButton(){
        logger.info("Starting clickHomeButton test");
        header.wHomeTab().click();
        Assert.assertEquals(driver.getTitle(), "SpringPetclinicAngular");
        logger.info("Ending clickHomeButton test");
    }

    @Test
    public void subTabs(){
        logger.info("Starting subTabs test");
        header.wOwnersTab().click();
        Assert.assertEquals(header.numberOfSubTabs(), 2);

        header.wVetTab().click();
        Assert.assertEquals(header.numberOfSubTabs(), 2);
logger.info("Ending subTabs test");
    }

    @Test
    public void petTypes(){
        logger.info("Starting petTypes test");
        header.wPetTypesTab().click();
        Assert.assertEquals(petTypes.petTypesText(), "Pet Types");
        logger.info("Ending petTypes test");
    }

    @Test
    public void specialties(){
        logger.info("Starting specialties test");
        header.wSpecialtiesTab().click();
        Assert.assertEquals(specialties.specialtiesText(), "Specialties");
        logger.info("Ending specialties test");
    }

    @Test
    public void allOwners(){
        logger.info("Starting allOwners test");
        header.wOwnersTab().click();
        header.wFirstSubTab().click();
        Assert.assertEquals(owners.ownersText(), "Owners");
        logger.info("Ending allOwners test");
    }

    @Test
    public void addNewOwner(){
        logger.info("Starting addNewOwner test");
        header.wOwnersTab().click();
        header.wSecondSubTab().click();

        Assert.assertEquals(ownersAdd.newOwnerText(), "New Owner");
        Assert.assertEquals(ownersAdd.numberOfFields(), 5);
        logger.info("Ending addNewOwner test");
    }

    @Test
    public void addNewVet(){
        logger.info("Starting addNewVet test");
        header.wVetTab().click();
        header.wSecondSubTab().click();

        Assert.assertEquals(vetsAdd.wNewVetText(), "New Veterinarian");
        Assert.assertEquals(vetsAdd.numberOfFields(), 2);
        logger.info("Ending addNewVet test");
    }

    @Test
    public void allVets(){
        logger.info("Starting allVets test");
        header.wVetTab().click();
        header.wFirstSubTab().click();
        Assert.assertEquals(vets.vetText(), "Veterinarians");
        logger.info("Ending allVets test");
    }
}