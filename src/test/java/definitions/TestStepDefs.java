package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class TestStepDefs {
    @Given("I open {string}")
    public void iOpen(String url) {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I login as a teacher")
    public void iLoginAsATeacher() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys("ask_instr@aol.com");
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys("ABC123");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }
}
