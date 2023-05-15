package ambyint.ToDoList.stepDefinitions;

import ambyint.ToDoList.utilities.BrowserFactory;
import io.cucumber.java.en.Given;

public class PreConditions {
    @Given("user launches the url")
    public void user_launches_the_url() {
        BrowserFactory.openChrome();
        BrowserFactory.launchUrl();
    }

}
