@links @smoke @teacher
  Feature: ASK predefined steps for Home Page links
 Background:
      Given I open "login" page
#      When I login as a teacher with credentials: "ask_instr@aol.com" and "ABC123"
#      When I login as a student with credentials: "student1@test.com" and "ABC123"
#      And I click button "Sign In"
#      And I wait for 1 sec
#      Then I verify user role as "TEACHER"
#      Then I verify as "STUDENT" user role



      @links1 @smoke @teacher
      Scenario: Links on the said menu of the home page
        When I login as a teacher with credentials: "ask_instr@aol.com" and "ABC123"
        And I click button "Sign In"
        And I wait for 1 sec
        Then I verify user role as "TEACHER"
        Given home page should be present
        When I click link "Submissions"
        And I wait for 1 sec
        Then "Submissions" page should be displayed
        Then I click "Home" page link
        And I wait for 1 sec
        Then I click link on the "Assignments"
        And "List of Assignments" should be present
        And I click "Quizzes" link on the main menu
        Then I click on link "Users Management"
        And "Users Management" page should be present
        Then I click on the "Settings"
        And "Settings" page be displayed
        And I wait for 2 sec
        Then I click "Home" page link
        And I click "Log Out"
        Then I confirm "Log Out"
        And I wait for 2 sec


       @links2 @smoke @teacher2
         Scenario: Links on the main home page
         When I login as a teacher with credentials: "ask_instr@aol.com" and "ABC123"
         And I click button "Sign In"
         And I wait for 1 sec
         Then I verify user role as "TEACHER"
         Given home page should be present
         Then I click on the "Go To Assignments" links
         And "List of Assignments" should be present
         And I wait for 1 sec
         Then I click "Home" page link
         Then I click on the "Go To Users Management" on  maine page
         And "Users Management" page should be present
         And I wait for 1 sec
         Then I click "Home" page link
         And I wait for 1 sec
         Then I click on "Go To Submissions" link on the main page
        Then "Submissions" page should be displayed


       @links3 @smoke2 @student1
       Scenario: Links on the said menu of the home page by student
         When I login as a student with credentials: "student1@test.com" and "ABC123"
         And I click button "Sign In"
         And I wait for 1 sec
         Then I verify as "STUDENT" user role
         Given home page should be present
         Then I click on the link "My Assignments"
         And should be present "My Assignments" on the home page
         Then I click on the "My Grades" link
         And "My Grades" page should be displayed on the home page
         And I wait for 1 sec
         Then I click on the "Settings"
         And "Settings" page be displayed
         Then I click "Home" page link
         And home page should be present
         And I wait for 1 sec
         And I click "Log Out"
         Then I confirm "Log Out"


         @link4 @smoke @student2
           Scenario: Links on the main home page by students
           When I login as a student with credentials: "student1@test.com" and "ABC123"
           And I click button "Sign In"
           And I wait for 1 sec
           Then I verify as "STUDENT" user role
           And I wait for 1 sec
           Then I click at the link "Go To My Assignments"
           And should be present "My Assignments" on the home page
           Then I click "Home" page link
           Then I click at link "Go To My Grades"
           And "My Grades" page should be displayed on the home page






























