package definitions;



import io.cucumber.java.en.And;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;

        import static support.TestContext.getDriver;
        import static org.assertj.core.api.Assertions.*;

public class ASK_PredefinedStepdefs {
    @Given("I open {string} page")
    public void iOpenPage(String url) {
        if (url.equals("login")){
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if(url.equals("registration")) {
            getDriver().get("http://ask.portnov.com/#/registration");
        }else {
            System.out.println("This site is not supported: "+ url);
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("I login as a teacher with credentials {string} and {string}")
    public void iLoginAsATeacherWithCredentialsAnd(String email, String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
    }

    @When("I type {string} into first name field VG")
    public void iTypeIntoFirstNameFieldVG(String fname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(fname);
    }


    @And("I type {string} into email field VG")
    public void iTypeIntoEmailFieldVG(String email) {


        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into group code field VG")
    public void iTypeIntoGroupCodeFieldVG(String gcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(gcode);
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String exMes) {
        String actMes = getDriver().findElement(By.xpath("//h4")).getText();
        assertThat (actMes.equals(exMes)).isTrue();
    }

    @Given("I type <lname> into last name field VG")
    public void iTypeIntoLastNameFieldVG() {

    }

    @And("I type {string} into password field VG")
    public void iTypeIntoPasswordFieldVG(String pass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
    }

    @And("I type {string} into confirm password field VG")
    public void iTypeIntoConfirmPasswordFieldVG(String cpass) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(cpass);
    }


    @Given("I type {string} into last name field VG")
    public void iTypeIntoLastNameFieldVG(String lname) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lname);
    }




}