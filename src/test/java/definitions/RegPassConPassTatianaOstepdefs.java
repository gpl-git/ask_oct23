package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class RegPassConPassTatianaOstepdefs {
    @When("I type {string} into first name field TO")
    public void iTypeIntoFirstNameFieldTO(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }

    @And("I type {string} into last name field TO")
    public void iTypeIntoLastNameFieldTO(String lname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lname);
    }

    @And("I type {string} into email field TO")
    public void iTypeIntoEmailFieldTO(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @When("I type {string} into group code field TO")
    public void iTypeIntoGroupCodeFieldTO(String gcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gcode);
    }

    @When("I type {string} into password field TO")
    public void iTypeIntoPasswordFieldTO(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @And("I type {string} into confirm password field TO")
    public void iTypeIntoConfirmPasswordFieldTO(String conpass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(conpass);
    }

    @Then("message {string} should be displayed TO")
    public void messageShouldBeDisplayedTO(String exMes) {
        String actMes = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat(actMes.equals(exMes)).isTrue();
    }

    @Then("error message {string} for password field should be displayed TO")
    public void errorMessageForPasswordFieldShouldBeDisplayedTO(String exErrorPass) {
        String actError = getDriver().findElement(By.xpath("//input[@formcontrolname='password']/../../..//mat-error")).getText();
        assertThat(actError.equals(exErrorPass)).isTrue();
    }

    @Then("error message {string} for confirm password field should be displayed TO")
    public void errorMessageForConfirmPasswordFieldShouldBeDisplayedTO(String exErrorCpass) {
        String actError = getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']/../../..//mat-error")).getText();
        assertThat(actError.equals(exErrorCpass)).isTrue();
    }

    @Then("password field should have attribute {string} as {string}")
    public void passwordFieldShouldHaveAttributeAs(String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).getAttribute(attribute)).isEqualTo(attributeValue);
    }

    @Then("confirm password field should have attribute {string} as {string}")
    public void confirmPasswordFieldShouldHaveAttributeAs(String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).getAttribute(attribute)).isEqualTo(attributeValue);
    }
}
