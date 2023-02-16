Feature: to move slider based on user input
    @run
    Scenario: download will start and then progress will be validated
        Given user is on jquery home page
        And user go to "Slider" page
        And user go to "Range slider" page

        Then user click slider "1" and slide it until "30" Dollar
        Then user click slider "2" and slide it until "100" Dollar

        Then sceanrio successfully performed