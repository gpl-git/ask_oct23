package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class Q_Total_Num_Stepdefs {
    @Given("I visit url {string}")
    public void iVisitUrl(String url) {
        if(url.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }
        else if (url.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("This website is not supported: " +url );
        }
    }

    @When("I login with teacher credentials {string} and {string}")
    public void iLoginWithTeacherCredentialsAnd(String usr, String pass) {
      getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(usr);
      getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @Then("I go to quizzes tab")
    public void iGoToQuizzesTab() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }
}
