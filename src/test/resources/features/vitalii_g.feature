@last_name @smoke @teacher
  Feature: Registration - Last Name

    Background:

      Given I open "registration" page
      When I type "V" into first name field VG
      And I type "pollong2n7x@chantellegribbon.com" into email field VG
      And I type "ABC" into group code field VG
      And I type "ABC123" into password field VG
      And I type "ABC123" into confirm password field VG


      Scenario: Alphanumeric and Special
        And I type "vbvbv" into last name field VG
        And I click button "Register Me"
        And I wait for 1 sec
        Then confirmation message "You have been Registered." is displayed VG
        And I wait for 2 sec

    @last_name1smoke
    Scenario Outline: Last name field testing  Positive
      And I type <lname> into last name field VG
      And I click button "Register Me"
      And I wait for 2 sec
      Then confirmation message <expMessage> is displayed VG
      Examples:
        | lname       | expMessage                  |
        | "vbvbv"     | "You have been Registered." |
        | "vbvbv123"  | "You have been Registered." |
        | "@#$^*&*(v" | "You have been Registered." |
        | "v"         | "You have been Registered." |

    @lname @lastname2
    Scenario Outline: Test
      And I type <lname> into last name field VG
      And I click button "Register Me"
      And I wait for 1 sec
      Then LN error message <expError> id displayed VG
      Examples:
        | lname                 | expError                 |
       | ""                    | "This field is required" |
        | " vbvbvb"        | "Whitespaces are not allowed"|
      #  known issue, more than 254 char
      # | "254fgkhcghkcgkhcgkcgkjcgjkgkjgckhcgh456576954e7eurfyjdfkjgdfgdfjkgfjsdjfkgsdjfgkdfjkgdfgfgh@#$%^%^%hvhjgvjhvjhvjhvjhhgcAAADXGFHGCJVFDZGFCHVNGCGFDHGVJNhgchjhvbkhjvcgfxhvjhchgfxhjvjmbcgffklbjgfxtdfgh;ldgjhgdfghjkm,nbvcxdftgyuhjjhgftyukmnbftyukmnfghjknbghhj"| "" |

