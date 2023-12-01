package definitions;

import io.cucumber.java.en.And;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class TextShowstopSalamatStepDefs {
    @And("I click checkbox button")
    public void iClickCheckboxButton() {
        getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
    }

    @And("I click checkbox button for showstopper")
    public void iClickCheckboxButtonForShowstopper() {
        getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
    }


    @And("I click on checkbox button for showstopper")
    public void iClickOnCheckboxButtonForShowstopper() {
        getDriver().findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
    }

    @And("I click on button Preview")
    public void iClickOnButtonPreview() {
       getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Automate Text QS - Showstopper Salamat')]/../../..//*[contains(text(),'Preview')]")).click();
    }

    @When("I open the quiz name {string}")
    public void iOpenTheQuizName(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Automate Text QS - Showstopper Salamat')]")).click();
    }

    @And("I click the quiz name {string}")
    public void iClickTheQuizName(String text) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Automate Text QS - Showstopper Salamat')]")).click();
    }

    @And("I click the quiz name")
    public void iClickTheQuizName() {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Automate Text QS - Showstopper Salamat')]")).click();
    }

    @Then("label with showstopper should be displayed")
    public void labelWithShowstopperShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).isDisplayed()).isTrue();
    }

    @And("I click on button close")
    public void iClickOnButtonClose() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @Then("the Q{int} should have * sign")
    public void theQShouldHaveSign(int arg0) {

    }

    @Then("the {string} should have * sign")
    public void theShouldHaveSign(String qsNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qsNum+"')]")).isDisplayed()).isTrue();

    }

    @And("I click on the button plus to add one more question")
    public void iClickOnTheButtonPlusToAddOneMoreQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("click on checkbox button for showstopper")
    public void clickOnCheckboxButtonForShowstopper() {
        getDriver().findElement(By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]")).click();
    }

    @And("Then the {string} should now have * sign")
    public void thenTheShouldNowHaveSign(String qsNum) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]")).isDisplayed()).isTrue();
    }

    @When("I type {string} into question text field {string}")
    public void iTypeIntoQuestionTextField(String text, String qsNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+qsNum+"')]/../../..//*[@formcontrolname='question']")).sendKeys(text);

    }

    @And("I click on the button close")
    public void iClickOnTheButtonClose() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @And("delete the quiz")
    public void deleteTheQuiz() {
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),' Automate Text QS - Showstopper Salamat')])[1]/../../..//*[contains(text(),'Delete')]")).click();
    }
}
