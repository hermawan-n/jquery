Feature: to type and click on autocomplete suggestion
    # @run
    Scenario: successfully hover on autocomplete and choose it
        Given user is on jquery home page
        And user go to "Autocomplete" page

        Then user type tags text box as "j"
        Then user hover on "Java" suggestion then clicks on it
        Then validate inside tags text box has "Java"

        Then sceanrio successfully performed