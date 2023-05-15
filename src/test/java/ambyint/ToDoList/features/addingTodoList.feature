@Regression
Feature: Adding Todo list
  As a user I want to add the todo list to the application

  Background: required browser is opened
    And user launches the url

  @low
  Scenario Outline: valid user inputs with number, text and symbols : TC001
    Given user enters "<todoList>" as toDoList
    When user hits enter
    Then user should see items in the list

    Examples:
      | todoList                      |
      | 123456789/*-+.!@#$%^&*()_+- ` |
      | Grocery shopping              |

  @low
  Scenario Outline: valid user inputs with spaces at the beginning, in between and at the end : TC002
    Given user enters "<todoList>" as toDoList
    When user hits enter
    Then user should see items in the list

    Examples:
      | todoList               |
      | hi123!                 |
      | hi123!          hi123@ |

  @medium
  Scenario Outline: valid user input for checking max length : TC003
    Given user enters "<todoList>" as toDoList
    When user hits enter
    Then user should see an error for max length

    Examples:
      | todoList                                                                                                                                      |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |

  @high
  Scenario Outline: Verify if duplicate inputs are allowed : TC004
    Given user enters "<todoList>" as toDoList
    When user hits enter
    Given user enters "<todoList>" as toDoList
    When user hits enter
    Then there should not be any duplicate entries

    Examples:
      | todoList    |
      | Buy Grocery |

  @high
  Scenario Outline: Verify when user tries to edit an existing ToDo list, it is edited and it shows new list : TC005
    Given user enters "Buy Grocery" as toDoList
    Then user hits enter
    And user enters "Running @ Treadmill" as toDoList
    And user hits enter
    And user enters "Change Tires." as toDoList
    And user hits enter
    And user enters "Pay credit card bill" as toDoList
    And user hits enter
    And user enters "Optimize scripts " as toDoList
    And user hits enter
    And user enters " Finish Ambyint project" as toDoList
    And user hits enter
    And user enters "Finish python programming tutorial" as toDoList
    And user hits enter
    And user enters "Enroll in a course  " as toDoList
    And user hits enter
    And user enters "Talk to manager about website" as toDoList
    And user hits enter
    And user enters "File> Open > Edit > Save" as toDoList
    And user hits enter
    And user clicks on dots and clicks on edit
    And user enters "<data>" as toDoList
    And user hits enter
    Then new list should be displayed
    Examples:
      | data  |
      | All 4 |

  @hgh
  Scenario Outline: Verify if user clicks on single list, it is crossed/completed : TC006
    Given user enters "<todoList>" as toDoList
    Then user hits enter
    When user clicks on same list
    Then user should see the todo list marked

    Examples:
      | todoList    |
      | Buy Grocery |

  @hign
  Scenario Outline: Verify if user clicks on single list, it is crossed/completed : TC007
    Given user enters "<todoList>" as toDoList
    Then user hits enter

    And user enters "Running @ Treadmill" as toDoList
    And user hits enter
    And user enters "Change Tires." as toDoList
    And user hits enter
    And user enters "Pay credit card bill" as toDoList
    And user hits enter
    And user enters "Optimize scripts " as toDoList
    And user hits enter
    And user enters " Finish Ambyint project" as toDoList
    And user hits enter
    And user enters "Finish python programming tutorial" as toDoList
    And user hits enter
    And user enters "Enroll in a course  " as toDoList
    And user hits enter
    And user enters "Talk to manager about website" as toDoList
    And user hits enter
    And user enters "File> Open > Edit > Save" as toDoList
    And user hits enter

    When user clicks on two random todo lists
    Then user should see the todo lists marked

    Examples:
      | todoList    |
      | Buy Grocery |

  @low
  Scenario Outline: Verify when the user deletes single added to-do list, the record is deleted : TC008
    Given user enters "<todoList>" as toDoList
    Then user hits enter
    When user clicks on dots and clicks on delete
    Then user should see the todo list deleted

    Examples:
      | todoList    |
      | Buy Grocery |

  @high
  Scenario Outline:Verify when the user deletes single added to-do list
  from a large list,  the respective record is deleted:                   TC009
    Given user enters "<todoList>" as toDoList
    Then user hits enter

    And user enters "Running @ Treadmill" as toDoList
    And user hits enter
    And user enters "Change Tires." as toDoList
    And user hits enter
    And user enters "Pay credit card bill" as toDoList
    And user hits enter
    And user enters "Optimize scripts " as toDoList
    And user hits enter
    And user enters " Finish Ambyint project" as toDoList
    And user hits enter
    And user enters "Finish python programming tutorial" as toDoList
    And user hits enter
    And user enters "Enroll in a course  " as toDoList
    And user hits enter
    And user enters "Talk to manager about website" as toDoList
    And user hits enter
    And user enters "File> Open > Edit > Save" as toDoList
    And user hits enter

    When user deletes on any todo list item
    Then only that item gets deleted

    Examples:
      | todoList    |
      | Buy Grocery |