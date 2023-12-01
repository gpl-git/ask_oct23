@login
Feature: Validate login page
  Background: I am at Login page
    Given I open "login" page

  @login1
  Scenario Outline: Login with valid credential
    When I type <email> into email field
    And I type <password> into password field
    And I type "" into password field
    Then I click button "Sign In"
    And I wait for 3 sec
    And I wait for 3 sec
    Then I verify logout option is displayed TN
    Examples:
      | email | password|
      | "student1@test.com"    | "ABC123" |
      | "ask_instr@aol.com"    | "ABC123" |
      | "student7@test.com"    | "ABC123" |
      | "qa.sofi@gmail.com"    | "ABC123" |

  @login2
  Scenario Outline: Login with invalid data
    When I type <email> into email field
    And I type <password> into password field
    Then I click button "Sign In"
    And I wait for 3 sec
    Then error message <exErrEmail> for the email field is displayed TN
    Then error message <exErrPass> for the password field is displayed TN
    Examples:
      | email | password  |  exErrEmail | exErrPass |
      | ""    | ""        |  ""         | ""        |
      | "student1@test.com"    | "AB C123"        |  ""         | ""        |
#      | "student1@test.com"    | "WGFSA132334EWHFUSIDY8234323T5EFDC"        |  ""| ""        |
##       Over 32 character max for password field
#      | "student1@test.com "    | "ABC123"        |  ""         | ""        |
#      | "student1@test.com"    | ""        |  ""         | ""        |
#      | "student1@test.com"    | "ABC1"        |  ""         | ""        |
#      | "student1test.com"    | "ABC123"        |  ""         | ""        |
#      | "student1@testcom"    | "ABC123"        |  ""         | ""        |
#      | "egrhjunnye ahut4fwa37yuhj lkinawr@#$Su5hy7r4fas32ywhj7kuntisegrhjunnye.ahut4fwa37yuhj lkinawr@#$Su5hy7r4fas32ywhj7kuntisfdfgewrre"    | "12847423"        |  ""         | ""        |
#      | "afsghfrdwreugifrrewhgnvkkdjfrsghjioghuqaghuirnfjmeifewhjvdghtjsdh@gma.net"    | "ABC123"        |  ""         | ""        |
#      | "afsghh@afsghfrdwreugifrrewhgnvkkdjfrsghjioghuqaghuirnfjmeifewhjvdghtjsdhd.net"    | "ABC123"        |  ""         | ""        |
#      | "afsghh@afs.afsghfrdwreugifrrewhgnvkkdjfrsghjioghuqaghuirnfjmeifewhjvdghtjsdhd"    | "ABC123"        |  ""         | ""        |


#  @login3
#  Scenario: Login with invalid credential
#    When I type "" into email field
#    And I type "" into password field
#    Then I click button "Sign In"
#    And I wait for 3 sec
#    Then I verify error alert message displayed TN
