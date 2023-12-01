package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.且つ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class ASK_PredefinedStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This website is not supported: " +url );
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I login as a teacher with credentials: {string} and {string}")
    public void iLoginAsATeacherWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I verify user role as {string}")
    public void iVerifyUserRoleAs(String role) {
        String actRole = getDriver().findElement(By.xpath("//mat-list")).getText();
        assertThat(actRole.contains(role)).isTrue();

    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String item) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'"+item+"')]")).click();
    }

    @And("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I select {string} question in {string}")
    public void iSelectQuestionIn(String questionType, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[contains(text(),'"+questionType+"')]")).click();
    }

    @When("I type {string} into question text field")
    public void iTypeIntoQuestionTextField(String questionText) {{
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]/../../..//*[@formcontrolname='question']"));
    }
    }

    @When("I type {string} into question text field of {string}")
    public void iTypeIntoQuestionTextFieldOf(String questionText, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@formcontrolname='question']")).sendKeys(questionText);

    }

    @And("I type {string} into {string} field of {string}")
    public void iTypeIntoFieldOf(String optionText, String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']")).sendKeys(optionText);
    }

    @When("I select {string} as correct option in {string}")
    public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//*[@placeholder='"+optionNum+"']/../../../../..//mat-radio-button")).click();
    }

    @Then("{string} is displayed on the list of quizzes")
    public void isDisplayedOnTheListOfQuizzes(String quizTitle) {
        List<WebElement> titles = getDriver().findElements(By.xpath("mat-expansion-panel"));
        for (WebElement title: titles) {
            if (title.getText().contains(quizTitle)){
                assertThat(title.isDisplayed()).isTrue();
            }


        }
    }

    @And("I delete {string} from the list of quizzes")
    public void iDeleteFromTherListOfQuizzes(String quizTitle) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+quizTitle+"')]/../../..//*[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//ac-modal-confirmation/..//*[contains(text(),'Delete')]")).click();
    }
}

