@quiz @smoke @teacher
Feature: ASK Predefined Steps for Quiz
  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "ayemay1@qrzemail.com" and "test6"
#    When I type {string} into email field
#    And I type {string} into password field
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @textQsShowstopper @smoke
  Scenario: Textual Question Showstopper
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "Automate Text QS - Showstopper Salamat" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Textual" question in "Q1"
    When I type "What does REST stand for?" into question text field of "Q1"
    And I click on checkbox button for showstopper
    Then the "Q1" should have * sign
    And I click on the button plus to add one more question
    And I select "Textual" question in "Q2"
    And I wait for 3 sec
    When I type "API stands for" into question text field "Q2"
    And click on checkbox button for showstopper
    And Then the "Q1" should now have * sign
    And I click button "Save"
    And I wait for 1 sec
    Then "Automate Text QS - Showstopper Salamat" is displayed on the list of quizzes
    And I wait for 1 sec
    And I click the quiz name
    And I wait for 1 sec
    And I click on button Preview
    Then label with showstopper should be displayed
    And I click on the button close
    And I delete "Automate Text QS - Showstopper Salamat" from the list of quizzes










