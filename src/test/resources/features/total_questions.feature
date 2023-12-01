@quiz @smoke @teacher
Feature: Total number of quiz questions
  Scenario: Minimum number of quiz
    Given I visit url "login"
    When I login with teacher credentials "elbrus007oor@apexhearthealth.com" and "test1234"
    Then I click on "Sign In" button
    Then I go to quizzes tab
    And I wait for 3 sec
