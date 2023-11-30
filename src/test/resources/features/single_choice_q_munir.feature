@singleChoiceShowStopper @smoke
Feature: ASK Predefined Steps for Quiz
  Background:
    Given I open "login" page
    When I login as a teacher with credentials: "mickonu1@jgroupdesigns.com" and "123@abc"
    And I click button "Sign In"
    And I wait for 1 sec
    Then I verify user role as "TEACHER"
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @singleChoiceShowStopper1 @smoke
  Scenario: Create a Quiz
    When I click button "Create New Quiz"
    And I wait for 1 sec
    And I type "Single Choice show stopper quiz" as quiz title
    And I wait for 1 sec
    When I add a question
    And I wait for 1 sec
    And I select "Single" question in "Q1"
    And I wait for 1 sec
    Then I verify that the text '"Show-Stopper"' is displayed in the bottom of the page
    And I wait for 1 sec
    When I click the show Stopper button
    And I wait for 1 sec
    Then I verify that the "*" should be displayed beside the question
