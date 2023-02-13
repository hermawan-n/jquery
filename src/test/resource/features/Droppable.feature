Feature: to test and validate drag and drop element
    @run
    Scenario: successfully validate drag and drop an element
        Given user is on jquery home page
        And user go to "Droppable" page
        Then user drag and drop element
        Then element successfully dropped