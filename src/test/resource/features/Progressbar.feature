Feature: to check and validate progressbar
    @run
    Scenario: download will start and then progress will be validated
        Given user is on jquery home page
        And user go to "Progressbar" page
        And user go to "Download Dialog" page

        Then user click "Start Download" and download will start
        Then validate "Cancel Download" button is displayed at "50%"
        Then validate "Cancel Download" button is displayed at "99%"

        Then sceanrio successfully performed