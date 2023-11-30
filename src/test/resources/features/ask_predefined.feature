@quiz @smoke
Feature: ASK Predefined steps for quiz
  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "kombalt@mysticwood.it" and "Welcome123"
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @quiz1 @smoke
    Scenario: Create a quiz
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "TA Quiz by Lena" as a quiz title
    When I add a question
    And I select "Single" question in "Q1"
    When I type "Question 1" into question text field of "Q1"
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I click button "Save"
    And I wait for 1 sec
    When "TA Quiz by Lena" is displayed on the list of quizzes
    And I delete "TA Quiz by Lena" from the list of quizzes