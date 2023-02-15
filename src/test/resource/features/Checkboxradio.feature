Feature: to select checkboxradio based on text on user input
    # @run
    Scenario: select and validate checkbboxradio
        Given user is on jquery home page
        And user go to "Checkboxradio" page

        Then user choose "New York" on checkboxradio "Select a Location"
        Then validate color of "New York" on checkbox "Select a Location"

        Then user choose "2 Star" on checkboxradio "Hotel Rating"
        Then validate color of "2 Star" on checkbox "Hotel Rating"

        Then user choose "1 King" on checkboxradio "Bed Type"
        Then validate color of "1 King" on checkbox "Bed Type"

        Then sceanrio successfully performed