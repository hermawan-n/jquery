Feature: to chose date dinamicly
    # @run
    Scenario: select and validate date that get chosen
        Given user is on jquery home page
        And user go to "Datepicker" page

        Then user input "02/14/2022" on datepicker
        Then validate background color on date "02/14/2022"

        Then sceanrio successfully performed