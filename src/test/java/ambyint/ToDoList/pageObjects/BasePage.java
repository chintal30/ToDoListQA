package ambyint.ToDoList.pageObjects;

import ambyint.ToDoList.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class='task-input']/input")
    private WebElement taskBoxInput;

    @FindBy(xpath = "//*[@class='task-input']/input/..")
    private WebElement taskBoxforEditing;

    @FindBy(xpath = "//*/p")
    private WebElement listBox;

    @FindBy(xpath = "(//*/p)[1]")
    private WebElement item1;
    @FindBy(xpath = "(//*/p)[2]")
    private WebElement item2;
    @FindBy(xpath = "//*[text()='Buy Grocery']")
    private WebElement checkTestSingle;
    @FindBy(xpath = "//*[text()='Pay credit card bill']")
    private WebElement checkTestSecond;
    @FindBy(id = "completed")
    private WebElement completedTab;
    @FindBy(id = "pending")
    private WebElement pendingTab;
    @FindBy(xpath = "//*[@class='task-box']")
    private WebElement allTasks;

    @FindBy(xpath = "//*[text()='Change Tires.']/../../div")
    private WebElement dots;
    @FindBy(xpath = "//*[contains(text(),'All 4')]/")
    private WebElement editedList;

    @FindBy(xpath = "(//*[text()='Change Tires.']/../../div/ul/li/i)[1]")
    private WebElement editButton;

    @FindBy(xpath = "//*[text()='Buy Grocery']/../../div")
    private WebElement dotsForDeleteSingle;
    @FindBy(xpath = "(//*[text()='Buy Grocery']/../../div/ul/li/i)[2]")
    private WebElement deleteSingleButton;

    @FindBy(xpath = "//*[text()='Buy Grocery']/../../div")
    private WebElement dotsForDeleteFromMany;
    @FindBy(xpath = "(//*[text()='Buy Grocery']/../../div/ul/li/i)[2]")
    private WebElement deleteSingleButtonFromMany;

    @FindBy(xpath = "//*[@class='task-box']")
    private WebElement taskBoxText;
    String mainString;

    public void enterToDoListItem(String s) {
        mainString = s;
        taskBoxInput.sendKeys(s);
    }

    public void hitEnter() {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnSingleAddedList() {
        checkTestSingle.click();
    }

    public void clickOnSecondAddedList() {
        checkTestSecond.click();
    }

    public void clickOnCompleted() {
        completedTab.click();
    }

    public boolean checkInCompletedTab(String task) {
        boolean bool = false;
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='task-box']/li"));
        for (WebElement each : elements) {
            if (each.getText().contains(task)) {
                bool = true;
                break;
            } else bool = false;
        }
        return bool;
    }

    public boolean checkInCompletedTabs(String[] tasks) {
        boolean bool = false;
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='task-box']/li"));
        for (String selected : tasks) {
            for (WebElement each : elements) {
                if (each.getText().contains(selected)) {
                    bool = true;
                    break;
                } else bool = false;
            }
        }
        return bool;
    }

    public void compareListItem() {
        String text = listBox.getText();
        String result = mainString.replaceAll("\\s+", " ").trim();
        Assert.assertEquals(text, result); //Actual, Expected
    }

    public void maxLength() {
        int textLength = mainString.length();
        System.out.println("Length of this input string is : " + textLength);
        System.out.println("Assuming maximum length = 140 for example");
        Assert.assertEquals(textLength, 140);
    }

    public void compareItems() {
        Assert.assertNotEquals(item1.getText(), item2.getText());
    }

    public void clickEdit() {
        dots.click();
        editButton.click();
    }

    public void getEditedText() {
        Assert.assertEquals(editedList.getText(), "Change Tires.All 4");
    }

    public void clickOnDotsForSingleDelete() {
        dotsForDeleteFromMany.click();
        deleteSingleButtonFromMany.click();
    }
    public String checkTextOnTaskBox(){
       return taskBoxText.getText();
    }
    public boolean checkingForSingleDeletedTaskFromMany(String task2) {
        boolean bool2 = false;
        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@class='task-box overflow']/li"));
        for (WebElement each2 : elements2) {
            System.out.println(each2.getText());
            if (each2.getText().contains(task2)) {
                bool2 = true;
                break;
            } else bool2 = false;
        }
        return bool2;
    }
}
