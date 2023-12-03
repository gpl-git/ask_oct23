package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class DemoStepDefs {
    @When("I type {int} alphanumeric caracters into question field of {string}")
    public void numberofCaractersInQuestionField(int numChr, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;

        String genString = RandomStringUtils.random(numChr, useLetters, useNumbers);
        System.out.println(genString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@formcontrolname='question']")).sendKeys(genString);
    }

    @Then("error message for text input field should be displayed")
    public void errorMessageForTextInputFieldShouldBeDisplayed() {

        assertThat(getDriver().findElement(By.xpath("//input[@formcontrolname='question']/../../..//mat-error")).isDisplayed()).isTrue();
    }

    @When("I add {int} Textual questions")
    public void iAddTextualQuestions(int numOfQuest) throws InterruptedException {
        for(int i = 1; i<=numOfQuest; i++){
            getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q"+i+"')]/../../..//*[contains(text(),'Textual')]")).click();
            String  xpath = "//mat-panel-title[contains(text(),'Q"+i+"')]/../../..//*[@formcontrolname='question']";
            Thread.sleep(1000);
            getDriver().findElement(By.xpath(xpath)).sendKeys("Textual Question " + i);
        }
    }

    @When("I add up to {int} options in {string}")
    public void iAddUpToOptionsIn(int numOptions, String questionNum) throws InterruptedException {
        for (int i = 3; i<=numOptions; i++){
            getDriver().findElement(By.xpath("//*[contains(text(), 'Q1')]/../../..//span[contains(text(),'Add Option')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//*[@placeholder='Option "+i+"*']")).sendKeys("Option " + i);

        }
    }

    @When("I click the show Stopper button")
    public void iClickTheShowStopperButton() {
        getDriver().findElement(By.xpath("//div[@class='checkbox']//span[contains(text(), '\"Show-Stopper\"')]")).click();

    }
}