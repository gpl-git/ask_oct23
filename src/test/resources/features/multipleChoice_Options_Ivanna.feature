@multiple_choice @smoke @teacher
Feature: Multiple Choice Question - Options
  Background:
    Given I open "login" page
    When I login with credentials: "muramio@agendarpromis.host" and "abc123" IP
    And I click button "Sign In"
    And I wait for 2 sec
    Then I verify user role as "TEACHER" IP
    And I wait for 2 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @multiple_choice1 @smoke
  Scenario: MC quiz cannot have less then 2 options
    When I click button "Create New Quiz" IP
    And I wait for 1 sec
    And I type "Multiple Choice Quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Multiple-Choice" question in "Q1"
    And I wait for 2 sec
    And I find setting button in "Option 1*" IP
    And I wait for 2 sec
    Then Delete Option is disabled IP

  @multiple_choice2 @smoke
  Scenario: MC  Question - add max numbers of Options
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "15 options" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I type "Question 1" into question text field of "Q1"
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    When I add up to 15 options in "Q1"
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 3 sec
    And I click button "Save"
    And I wait for 1 sec
    Then "15 options" is displayed on the list of quizzes
    And I delete "15 options" from the list of quizzes
    And I wait for 3 sec

  @multiple_choice3 @smoke
  Scenario: MC  Question - number of Options 15+ (negative)
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "16 choices" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I type "Question 1" into question text field of "Q1"
    And I wait for 2 sec
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I wait for 1 sec
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I wait for 2 sec
    When I add up to 3 options in "Q1"
    And I wait for 2 sec
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 3 sec
    And I click button "Save"
    And I wait for 1 sec
    # This is bug  OCT23-105
    Then error message for text input field should be displayed
    And I wait for 3 sec

  @multiple_choice4 @smoke
  Scenario: include "Other" text area option for MC question
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "Other Text Area" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I type "Question 1" into question text field of "Q1"
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 3 sec
    And I include "Other" text area option IP
    And I wait for 3 sec
    And I click button "Save"
    And I wait for 3 sec
    Then I verify "Other Text Area" contains 'Other' text area option IP
    And I wait for 3 sec
    And I delete "Other Text Area" from the list of quizzes
    And I wait for 3 sec

  @multiple_choice5 @smoke
  Scenario: For MC more than one option is available to select as correct option
    When I click button "Create New Quiz"
    And I wait for 2 sec
    And I type "2 correct options" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I type "Question 1" into question text field of "Q1"
    And I wait for 2 sec
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I wait for 2 sec
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I wait for 2 sec
    When I add up to 5 options in "Q1"
    And I wait for 3 sec
    And I select "Option 1*" as correct option in "Q1" IP
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 2 sec
    And I click button "Save"
    And I wait for 2 sec
    Then "2 correct options" is displayed on the list of quizzes
    And I delete "2 correct options" from the list of quizzes IP
    And I wait for 3 sec