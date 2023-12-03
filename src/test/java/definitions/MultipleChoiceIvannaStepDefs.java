package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @When("I add {int} multiple questions")
    public void iAddMultipleQuestions(int numOfQuest) throws InterruptedException {
        for (int i = 1; i <= numOfQuest; i++) {
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'Multiple-Choice')]")).click();
            String xpath = "//mat-panel-title[contains(text(),'Q" + i + "')]/../../..//*[@formcontrolname='question']";
            Thread.sleep(1000);
            getDriver().findElement(By.xpath(xpath)).sendKeys("Multiple-Choice " + i);
        }
    }

    @And("I find setting button in {string} IP")
    public void iFindSettingButtonInIP(String optionNum) {
        getDriver().findElement(By.xpath("//*[contains(text(), '" + optionNum + "')]/../../../../../..//mat-icon[contains(text(), 'settings')]")).click();
    }

    @Then("Delete Option is disabled IP")
    public void deleteOptionIsDisabledIP() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']")).isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//button[@class='mat-menu-item']//span[contains(text(), 'Delete Option')]")).getAttribute("disabled");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[@class='mat-menu-item']//span[contains(text(), 'Close Menu')]")).click();
    }

    @And("I include {string} text area option IP")
    public void iIncludeTextAreaOption(String other) {
        getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
    }

    @Then("I verify {string} contains 'Other' text area option IP")
    public void iSelectFromTheListOfQuizzesIP(String quizTitle) throws InterruptedException {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-expansion-panel"));
        for (WebElement title : titles) {
            if (title.getText().contains(quizTitle)) {
                title.click();
            }
            Thread.sleep(5000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizTitle + "')]/../../..//span[contains(text(), 'Preview')]")).click();
            Thread.sleep(5000);
            assertThat(getDriver().findElement(By.xpath("//mat-dialog-container//textarea[@placeholder='Other']")).isDisplayed()).isTrue();
            getDriver().findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        }
    }
}