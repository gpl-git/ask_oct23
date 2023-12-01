@textualQ_text
Feature: ASK Predefined Steps for Textual Question Text

  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "perminov45@adamcoloradofitness.com" and "ABC1234"
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @textualQ_text1
  Scenario: Allowable characters: Alphanumeric & Sp. characters
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "QA Automation Engineer" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    And I wait for 1 sec
    When I type "Question 12@$&%()>{}[]" into question text field of "Q1"
    And I click button "Save"
    And I wait for 1 sec
    Then "QA Automation Engineer" is displayed on the list of quizzes
    And I preview on Quiz "QA Automation Engineer"
    And I wait for 5 sec
    Then  I verify that the question field displayed text "Question 12@$&%()>{}[]"
    And I wait for 3 sec
    And I click button "Close"
    And I wait for 5 sec
    And I delete the "QA Automation Engineer" Quiz
    And I wait for 3 sec

  @textualQ_text2
  Scenario:The Field is Required
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "QA Automation Engineer" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    And I click button "Save"
    And I wait for 5 sec
    Then error message "This field is required" should be displayed on page
    And I wait for 5 sec

  @textualQ_text3
  Scenario: Max 1001 alphanumeric characters (Negativ)
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "QA Automation Engineer 1001" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    When I type 1001 alphanumeric characters into question field of "Q1"
    And I wait for 15 sec
    And I click button "Save"
    # This is bug  OCT23-184
    Then error message for text input field should be displayed

  @textualQ_text4
  Scenario: Max 1000 alphanumeric characters (Positive)
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "QA Automation Engineer 1000" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    When I type 1000 alphanumeric characters into question field of "Q1"
    And I wait for 1 sec
    And I click button "Save"
    And I wait for 1 sec
    Then "QA Automation Engineer 1000" is displayed on the list of quizzes
    And I delete "QA Automation Engineer 1000" from the list of quizzes
    And I wait for 5 sec




