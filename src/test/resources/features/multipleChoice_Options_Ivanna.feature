@multiple_choice @smoke @teacher
Feature: Multiple Choice Question - Options
  Background:
    Given I open "login" page
    When I login with credentials: "muramio@agendarpromis.host" and "abc123" IP
    And I click button "Sign In"
    And I wait for 2 sec
    Then I verify user role as "TEACHER" IP
#    Then I verify user role as "TEACHER"
    And I wait for 2 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @multiple_choice1 @smoke
  Scenario: Multiple choice question required input name
    When I click button "Create New Quiz" IP
    And I wait for 2 sec
    And I type "Multiple Choice Quiz" as quiz title
    And I wait for 2 sec
    When I add a question
    And I wait for 1 sec
    And I select "Multiple-Choice" question in "Q1"
    And I click button "Save"
    Then element that contain error message "This field is required" should be displayed

  @multiple_choice2 @smoke
  Scenario: Quiz Multiple Choice Question: length = 1000 characters
    When I click button "Create New Quiz" IP
    And I wait for 1 sec
    And I type "Multiple Choice Quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Multiple-Choice" question in "Q1"
    When I type 1000 alphanumeric characters into question field of "Q1" IP
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I wait for 1 sec
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 2 sec
    And I click button "Save"
    Then "Multiple Choice Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "Multiple Choice Quiz" from the list of quizzes IP
    And I wait for 5 sec

  @multiple_choice3 @smoke
  Scenario: Quiz Multiple Choice Question: length = 1000 characters
    When I click button "Create New Quiz" IP
    And I wait for 1 sec
    And I type "Multiple Choice Quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Multiple-Choice" question in "Q1"
    When I type 1000 alphanumeric characters into question field of "Q1" IP
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I wait for 1 sec
    And I select "Option 2*" as correct option in "Q1" IP
    And I wait for 2 sec
    And I click button "Save"
    Then "Multiple Choice Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "Multiple Choice Quiz" from the list of quizzes IP
    And I wait for 5 sec

  @multiple_choice4 @smoke
  Scenario: MC  Question - number of choices
    When I click button "Create New Quiz"
    And I wait for 3 sec
    And I type "15 choices" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I type "Question 1" into question text field of "Q1"
    And I wait for 3 sec
    And I type "Option 1" into "Option 1*" field of "Q1"
    And I wait for 3 sec
    And I type "Option 2" into "Option 2*" field of "Q1"
    And I wait for 3 sec
    When I add up to 15 options in "Q1"
    And I wait for 3 sec
    And I select "Option 1*" as correct option in "Q1" IP
    And I select "Option 2*" as correct option in "Q1" IP
    And I select "Option 3*" as correct option in "Q1" IP
    And I select "Option 4*" as correct option in "Q1" IP
    And I select "Option 5*" as correct option in "Q1" IP
    And I select "Option 6*" as correct option in "Q1" IP
    And I select "Option 7*" as correct option in "Q1" IP
    And I select "Option 8*" as correct option in "Q1" IP
    And I select "Option 9*" as correct option in "Q1" IP
    And I select "Option 10*" as correct option in "Q1" IP
    And I select "Option 11*" as correct option in "Q1" IP
    And I select "Option 12*" as correct option in "Q1" IP
    And I select "Option 13*" as correct option in "Q1" IP
    And I select "Option 14*" as correct option in "Q1" IP
    And I select "Option 15*" as correct option in "Q1" IP
#    And I select up to 15 options in "Q1" IP
    And I wait for 5 sec
    And I click button "Save"
    And I wait for 3 sec
    Then "15 choices" is displayed on the list of quizzes
    And I delete "15 choices" from the list of quizzes IP
    And I wait for 5 sec
