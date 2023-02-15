Feature: to test and validate selectable element
    # @run
    Scenario: successfully reorder item list and validate them
        Given user is on jquery home page
        And user go to "Sortable" page

        Then user choose item "2" to drop at index "3"
        Then validate index "1" contains text item "1"
        Then validate index "2" contains text item "3"
        Then validate index "3" contains text item "2"
        Then validate index "4" contains text item "4"
        Then validate index "5" contains text item "5"
        Then validate index "6" contains text item "6"
        Then validate index "7" contains text item "7"

        Then sceanrio successfully performed