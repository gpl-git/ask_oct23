package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class MultipleChoiceIvannaStepDefs {

    @When("I login with credentials: {string} and {string} IP")
    public void iLoginWithCredentialsAndIP(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I verify user role as {string} IP")
    public void iVerifyUserRoleAsIP(String role) {
        String actRole = getDriver().findElement(By.xpath("//div//p[contains(text(),'" + role + "')]")).getText();
        assertThat(actRole.equals(role)).isTrue();
    }

    @When("I click button {string} IP")
    public void iClickButtonIP(String button) {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper' and contains(text(), '" + button + "')]")).click();
    }

    @When("I type {int} alphanumeric characters into question field of {string} IP")
    public void iTypeAlphanumericCharactersIntoQuestionFieldOfIP(int numChr, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;

        String genString = RandomStringUtils.random(numChr, useLetters, useNumbers);
        System.out.println(genString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@formcontrolname='question']")).sendKeys(genString);
    }

    @And("I delete {string} from the list of quizzes IP")
    public void iDeleteFromTheListOfQuizzesIP(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//*[contains(text(),'Delete')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ac-modal-confirmation/..//*[contains(text(),'Delete')]")).click();
    }

    @And("I select {string} as correct option in {string} IP")
    public void iSelectAsCorrectOptionInIP(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@placeholder='" + optionNum + "']/../../../../..//mat-checkbox")).click();
    }

    @Then("element that contain error message {string} should be displayed")
    public void elementThatContainErrorMessageShouldBeDisplayed(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Question *']/../../..//mat-error[contains(text(), 'This field is required')]")).isDisplayed()).isTrue();
    }

//    @And("I select up to {int} options in {string} IP")
//    public void iSelectUpToOptionsInIP(int optionNum, String questionNum) {
//        for (int i = 15; i <= optionNum; i++) {
//            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@placeholder='" + optionNum + "']/../../../../..//mat-checkbox")).click();
////            getDriver().findElement(By.xpath("//*[contains(text(), 'Q1')]/../../..//span[contains(text(),'Add Option')]")).click();
//            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@placeholder='Option " + i + "*']")).sendKeys("Option " + i);
//        }
//    }
}