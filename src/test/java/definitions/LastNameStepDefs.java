package definitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class LastNameStepDefs {
    @Then("confirmation message {string} is displayed VG")
    public void confirmationMessageIsDisplayedVG(String expMessage) {
        String actMessage = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(expMessage.equals(actMessage)).isTrue();


    }

    @When("I login as a teacher with credentials {string} and {string}")
    public void iLoginAsATeacherWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (url.equals("registration")) {
            getDriver().get("http://ask.portnov.com/#/registration");
        } else {
            System.out.println("This site is not supported: " + url);
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int ignoredSec) throws InterruptedException {
        Thread.sleep(ignoredSec * 1000);
    }



    @When("I type {string} into first name field VG")
    public void iTypeIntoFirstNameFieldVG(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }

    @And("I type {string} into email field VG")
    public void iTypeIntoEmailFieldVG(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into group code field VG")
    public void iTypeIntoGroupCodeFieldVG(String gcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gcode);
    }

    @And("I type {string} into password field VG")
    public void iTypeIntoPasswordFieldVG(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @And("I type {string} into confirm password field VG")
    public void iTypeIntoConfirmPasswordFieldVG(String cpass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(cpass);
    }

    @And("I type {string} into last name field VG")
    public void iTypeIntoLastNameFieldVG(String lname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lname);
    }

    @And("I click button {string}")
    public void iClickButton(String arg0) {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
    }


    @Then("error message <errMessage> is displayed VG")
    public void errorMessageErMessageIsDisplayedVG(String errMessage) {
        String actMessage = getDriver().findElement(By.id("mat-error-6")).getText();
        assertThat(errMessage.equals(actMessage)).isTrue();
    }

    @Then("error message <errMessage> is displayed VG")
    public void errorMessageErrMessageIsDisplayedVG(String errMessage) {
        String actMessage = getDriver().findElement(By.id("mat-error-6")).getText();
        assertThat(errMessage.equals(actMessage)).isTrue();
    }
}










