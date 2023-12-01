package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;
public class ASK_HomePageLinks_OlhaM {
    @Given("home page should be present")
    public void homePageShouldBePresent() {
        assertThat(getDriver().findElement(By.xpath("//*[@class='mat-list']")).isDisplayed()).isTrue();


    }

    @When("I click link {string}")
    public void iClickLink(String subm) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='Submissions']")).click();

    }

    @Then("{string} page should be displayed")
    public void pageShouldBeDisplayed(String arg005) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']")).isDisplayed()).isTrue();
    }

    @Then("I click {string} page link")
    public void iClickPageLink(String home) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='Home']")).click();

    }

    @Then("I click link on the {string}")
    public void iClickLinkOnThe(String assig) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='Assignments']")).click();
    }


    @And("{string} should be present")
    public void shouldBePresent(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']//*[text()='List of Assignments']")).isDisplayed()).isTrue();
    }


    @And("I click {string} link on the main menu")
    public void iClickLinkOnTheMainMenu(String quiz) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='Quizzes']")).click();
    }

    @Then("I click on link {string}")
    public void iClickOnLink(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']/*[text()='Users Management']")).click();
    }

    @And("{string} page should be present")
    public void pageShouldBePresent(String mana) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']/h4[contains(text(),'Management')]")).isDisplayed()).isTrue();


    }

    @Then("I click on the {string}")
    public void iClickOnThe(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']/*[text()='Settings']")).click();

    }

    @And("{string} page be displayed")
    public void pageBeDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='ng-star-inserted']//*[text()='Settings']")).isDisplayed()).isTrue();
    }

    @And("I click {string}")
    public void iClick(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-item-content']//*[text()='Log Out']")).click();
    }

    @Then("I confirm {string}")
    public void iConfirm(String arg0) {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-warn']")).click();
    }

    @Then("I click on the {string} links")
    public void iClickOnTheLinks(String arg0) {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-primary']//*[text()='Go To Assignments']")).click();
    }

    @Then("I click on the {string} on  maine page")
    public void iClickOnTheOnMainePage(String arg0) {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-primary']//*[text()='Go To Users Management']")).click();

    }


    @Then("I click on {string} link on the main page")
    public void iClickOnLinkOnTheMainPage(String arg0) {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-primary']//*[text()='Go To Submissions']")).click();

    }

    @Then("{string} page should not be displayed")
    public void pageShouldNotBeDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']")).isDisplayed()).isFalse();
    }


    @When("I login as a student with credentials: {string} and {string}")
    public void iLoginAsAStudentWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I verify as {string} user role")
    public void iVerifyAsUserRole(String role1) {
        String actRole = getDriver().findElement(By.xpath("//*[text()='STUDENT']")).getText();
        assertThat(actRole.contains(role1)).isTrue();
    }

    @Then("I click on the link {string}")
    public void iClickOnTheLink(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='My Assignments']")).click();
    }


    @And("should be present {string} on the home page")
    public void shouldBePresentOnTheHomePage(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']//*[text()='My Assignments']")).isDisplayed()).isTrue();
    }

    @Then("I click on the {string} link")
    public void iClickOnTheLin(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-list-text']//*[text()='My Grades']")).click();
    }


    @And("{string} page should be displayed on the home page")
    public void pageShouldBeDisplayedOnTheHomePage(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[@class='page mat-card']/h4[contains(text(),'Grades')]")).isDisplayed()).isTrue();
    }


    @Then("I click at the link {string}")
    public void iClickAtTheLink(String goToMyAss) {
        getDriver().findElement(By.xpath("//*[@class='mat-button mat-primary']//*[text()='Go To My Assignments']")).click();
    }


    @Then("I click at link {string}")
    public void iClickAtLink(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-button mat-primary']//*[text()='Go To My Grades']")).click();
    }
}











