package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class login_trudyStepdefs {
    @Then("I verify logout option is displayed TN")
    public void iVerifyLogoutOptionIsDisplayed() {
        getDriver().findElement(By.xpath("//div[./h5[text()='Log Out']]")).isDisplayed();
    }

    @Then("error message {string} for the email field is displayed TN")
    public void errorMessageForTheEmailFieldIsDisplayedTN(String exErrEmail) {
        String actErrEmail = getDriver().findElement(By.xpath("//input[@placeholder='Email *']/../../..//mat-error")).getText();
       assertThat(actErrEmail.equals(exErrEmail)).isTrue();
//        assertEquals(exErrEmail, actErrEmail);
    }

    @Then("error message {string} for the password field is displayed TN")
    public void errorMessageForThePasswordFieldIsDisplayedTN(String exErrPass) {
        String actErrPass = getDriver().findElement(By.xpath("//input[@placeholder='Password *']/../../..//mat-error")).getText();
        assertThat(actErrPass.equals(exErrPass)).isTrue();
//        assertEquals(exErrPass, actErrPass);
    }


    @Then("I verify error alert message displayed TN")
    public void iVerifyErrorAlertMessageDisplayedTN() {
    }
}
