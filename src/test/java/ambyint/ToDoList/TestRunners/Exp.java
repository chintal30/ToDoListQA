package ambyint.ToDoList.TestRunners;

import ambyint.ToDoList.pageObjects.BasePage;
import ambyint.ToDoList.utilities.BrowserFactory;
import org.testng.annotations.Test;

public class Exp {
    @Test
    public void test(){
        BrowserFactory.openChrome();
        BrowserFactory.launchUrl();
        BasePage bbb=new BasePage(BrowserFactory.getDriver());
        bbb.enterToDoListItem("ss");
        bbb.hitEnter();
        bbb.enterToDoListItem("ss");
        bbb.hitEnter();

    }


}
