package ambyint.ToDoList.stepDefinitions;

import ambyint.ToDoList.pageObjects.BasePage;
import ambyint.ToDoList.utilities.BrowserFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class addingTodoListHooks {

    BasePage bp = new BasePage(BrowserFactory.getDriver());

    @Given("user enters {string} as toDoList")
    public void user_enters_as_to_do_list(String string) {

        bp.enterToDoListItem(string);
    }

    @When("user hits enter")
    public void user_hits_enter() {
        bp.hitEnter();
    }

    @Then("user should see items in the list")
    public void user_should_see_items_in_the_list() {
        bp.compareListItem();
    }

    @Then("user should see an error for max length")
    public void user_should_see_an_error_for_max_length() {
        bp.maxLength();
    }


    @Then("there should not be any duplicate entries")
    public void there_should_not_be_any_duplicate_entries() {
        bp.compareItems();
    }

    @Then("user clicks on dots and clicks on edit")
    public void user_clicks_on_dots_and_clicks_on_edit() {
        bp.clickEdit();
    }

    @Then("new list should be displayed")
    public void new_list_should_be_displayed() {
        Assert.assertEquals(bp.getEditedText(), "Change Tires.All 4");
    }
    @When("user clicks on same list")
    public void user_clicks_on_same_list() {
        bp.clickOnSingleAddedList();
        bp.clickOnCompleted();

    }
    @Then("user should see the todo list marked")
    public void user_should_see_the_todo_list_marked() {
        boolean b= bp.checkInCompletedTab("Buy Grocery");
        Assert.assertTrue(b);
    }

    @When("user clicks on two random todo lists")
    public void user_clicks_on_random_todo_lists() {
        bp.clickOnSingleAddedList();
        bp.clickOnSecondAddedList();
        bp.clickOnCompleted();

    }
    @Then("user should see the todo lists marked")
    public void user_should_see_the_todo_lists_marked() {
       boolean b= bp.checkInCompletedTabs(new String[]{"Buy Grocery","Pay credit card bill"});
        Assert.assertTrue(b);
    }
    @When("user clicks on dots and clicks on delete")
    public void user_clicks_on_dots_and_clicks_on_delete() {
        bp.clickOnDotsForSingleDelete();
    }
    @Then("user should see the todo list deleted")
    public void user_should_see_the_todo_list_deleted() {
        Assert.assertEquals(bp.checkTextOnTaskBox(),"You don't have any task here");
    }
    @When("user deletes on any todo list item")
    public void user_deletes_on_any_todo_list_item() {
        bp.clickOnDotsForSingleDelete();
    }
    @Then("only that item gets deleted")
    public void only_that_item_gets_deleted() {
        boolean bb= bp.checkingForSingleDeletedTaskFromMany("Pay credit card bill");
        System.out.println(bb);
        Assert.assertFalse(bb);
    }


}
