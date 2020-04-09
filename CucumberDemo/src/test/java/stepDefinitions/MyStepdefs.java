package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyStepdefs {



    @Given("^User is on NetBanking landing page$")
    public void userIsOnNetBankingLandingPage()  throws Exception{

        System.out.println("navigated to login url...");
        //throw new PendingException();
        
    }

    @When("^User login into application with username and password$")
    public void userLoginIntoApplicationWithUsernameAndPassword() throws Exception{

        System.out.println("Successfully logged in...");
        //throw new PendingException();
    }

    @Then("^Home page is populated$")
    public void homePageIsPopulated() throws Exception{

        System.out.println("Home page success...");

        //throw new PendingException();
        
    }

    @And("^Cards are displayed$")
    public void cardsAreDisplayed() throws Throwable{

        System.out.println("Cards displayed....");
       /// throw new PendingException();

    }
}
