
import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //opens windov in full screen
        driver.get("http://bvtest.school.cubes.rs/login");
        
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        
        
        WebElement signaturesLink = driver.findElement(By.linkText("Signatures"));
        signaturesLink.click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        //CATEGORISES
        
        //go to categories page
        
        WebElement categoriesLink = driver.findElement(By.partialLinkText("Cat"));
        categoriesLink.click();
        System.out.println("Page title is: " + driver.getTitle());
        
        //Click on "Add category" button, Fill the field, and click on "Save" button
        
        WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
        addCategoryButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
        
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        // or driver.findElement(By.id("save-category-button")).click();
        
        //REGIONES
        
        WebElement navBar = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTags = navBar.findElements(By.tagName("li"));
        liTags.get(4).click();
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addPortalButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addPortalButton.click();
        
        Thread.sleep(7000);
        driver.quit();
        
        
   
        
    }
    
}
