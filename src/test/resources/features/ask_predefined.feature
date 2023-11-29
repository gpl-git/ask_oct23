@quiz @smoke @teacher
Feature: ASK Predefined Steps for Quiz
  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "ask_instr@aol.com" and "ABC123"
#    When I type {string} into email field
#    And I type {string} into password field
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @suiz1 @smoke
    Scenario: Create a Quiz
     When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "TA Demo Quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Single" question in "Q1"
    When I type "Question 1" into question text field of "Q1"
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I click button "Save"
    And I wait for 1 sec
    Then "TA Demo Quiz" is displayed on the list of quizzes
    And I delete "TA Demo Quiz" from the list of quizzes
    And I wait for 5 sec




