Feature: to move slider based on user input
    # @run
    Scenario: download will start and then progress will be validated
        Given user is on jquery home page
        And user go to "Tooltip" page

        Then user hover to textbox
        Then validate the text inside tooltip as "We ask for your age only for statistical purposes."

        Then sceanrio successfully performed