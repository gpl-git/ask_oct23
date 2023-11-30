@password @smoke
  Feature: ASK Predefined Steps for Registration - Password / Confirm Password
    Background:
      Given I open "registration" page
      When I type "Tatiana" into first name field TO
      And I type "Okeke" into last name field TO
      And I type "jayblay@ericknoel07.website" into email field TO
      And I type "XXXX" into group code field TO

    @password1 @smoke
    Scenario Outline: Password and Confirm Password valid input
      When I type <pass> into password field TO
      And I type <conpass> into confirm password field TO
      And I click button "Register Me"
      And I wait for 3 sec
      Then message "You have been Registered." should be displayed TO
      Examples:
        | pass    | conpass |
        | "AB12&@34" | "AB12&@34" |
        | "AB12&" | "AB12&" |
        | "jb677AAAAJBJHjb677AAAAJBJHjb677A" | "jb677AAAAJBJHjb677AAAAJBJHjb677A" |


    @password2
    Scenario Outline: Password and Confirm Password invalid input / error messages
      When I type <pass> into password field TO
      And I type <conpass> into confirm password field TO
      And I click button "Register Me"
      Then error message <exErrorPass> for password field should be displayed TO
      Then error message <exErrorCpass> for confirm password field should be displayed TO
      Examples:
        | pass | conpass | exErrorPass              | exErrorCpass             |
        | ""       | ""          | "This field is required"          | "This field is required" |
        | "123 4"  | "123 4"     | "Whitespaces are not allowed"     | "Whitespaces are not allowed" |
        | "1234"   | "1234"      | "Should be at least 5 characters" | "Should be at least 5 characters" |
        | ""       | "ABC123"    | "This field is required"          | "Entered passwords should match" |

      @password3
      Scenario: Password is masked
        When I type "12345" into password field TO
        And I type "12345" into confirm password field TO
        Then password field should have attribute "type" as "password"
        Then confirm password field should have attribute "type" as "password"


