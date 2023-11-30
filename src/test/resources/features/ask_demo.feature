
@demo
Feature: Quiz Options
  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "ask_instr@aol.com" and "ABC123"
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @demo1
  Scenario: Quiz Textual Question length
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "TA Demo Quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    When I type 1001 alphanumeric caracters into question field of "Q1"
    And I click button "Save"
#    This is a known issue OCT23-444
    Then error message for text input field should be displayed

    @demo2
    Scenario: Quiz - Number of Questions
      When I click button "Create New Quiz"
      And I wait for 1 sec
      And I type "TA Demo Quiz" as quiz title
      When I add 8 Textual questions
      And I wait for 1 sec
      And I click button "Save"
      And I wait for 1 sec
      Then "TA Demo Quiz" is displayed on the list of quizzes
      And I delete "TA Demo Quiz" from the list of quizzes
      And I wait for 2 sec

    @demo
    Scenario: SC  Question - number of Options
      When I click button "Create New Quiz"
      And I wait for 1 sec
      And I type "TA Demo Quiz" as quiz title
      And I add a question
      When I select "Single" question in "Q1"
      And I type "Question 1" into question text field of "Q1"
      And I type "Option 1" into "Option 1*" field of "Q1"
      And I type "Option 2" into "Option 2*" field of "Q1"
      When I add up to 5 options in "Q1"
      When I select "Option 2*" as correct option in "Q1"
      And I wait for 5 sec
      And I click button "Save"
      And I wait for 1 sec
      Then "TA Demo Quiz" is displayed on the list of quizzes
      And I delete "TA Demo Quiz" from the list of quizzes
      And I wait for 5 sec
      
