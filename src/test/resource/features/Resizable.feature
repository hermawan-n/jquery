Feature: to test and validate resizable element
    @run
    Scenario: successfully validate resizable element
        Given user is on jquery home page
        And user go to "Resizable" page
        Then user resize the element width as 190 and height as 170
        And validate if element height equals 190 and height equals 170
        Then sceanrio successfully performed