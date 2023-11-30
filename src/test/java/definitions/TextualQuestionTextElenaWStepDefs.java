package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;


public class TextualQuestionTextElenaWStepDefs {
    @And("I preview on Quiz {string}")
    public void iClickOnQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Preview')]")).click();
    }

    @Then("I verify that the question field displayed text {string}")
    public void iVerifyThatTheQuestionFieldDisplayedText(String questionText) {
        String actquestionText = getDriver().findElement(By.xpath("//ac-quiz-preview")).getText();
         assertThat(actquestionText.contains(questionText)).isTrue();
    }

    @And("I delete the {string} Quiz")
    public void iDeleteTheQuiz(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation/..//*[contains(text(),'Delete')]")).click();
    }

    @Then("error message {string} should be displayed on page")
    public void errorMessageShouldBeDisplayedOnPage(String errorMess) {
        String actError = getDriver().findElement(By.xpath("//mat-error")).getText();
        assertThat(actError.equals(errorMess)).isTrue();
    }

    @When("I type {int} alphanumeric characters into question field of {string}")
    public void iTypeAlphanumericCharactersIntoQuestionFieldOf(int numChr, String questionNum) {
        boolean useLetters = true;
        boolean useNumbers = true;

        String genString = RandomStringUtils.random(numChr, useLetters, useNumbers);
        System.out.println(genString);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNum + "')]/../../..//*[@formcontrolname='question']")).sendKeys(genString);
    }
}


