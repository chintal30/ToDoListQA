package ambyint.ToDoList.stepDefinitions;

import ambyint.ToDoList.utilities.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

public class Hooks {
    @After
    public static void closeBrowser(){
        BrowserFactory.closeAllWindows();
    }
}
