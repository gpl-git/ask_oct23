@login
Feature: Validate login page
  Background: I am at Login page
    Given I open login page

  @login1
  Scenario: Login with valid credential
    When I type "" into the password field
    And I type "" into the
