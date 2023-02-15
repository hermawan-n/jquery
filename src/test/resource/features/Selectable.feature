Feature: to test and validate selectable element
    # @run
    Scenario: successfully click multiple element
        Given user is on jquery home page
        And user go to "Selectable" page
        And user go to "Display as grid" page

        Then user choose element on row "1" and column "2" and when element get selected show yellow background color
        Then user choose element on row "2" and column "2" and when element get selected show yellow background color
        Then user choose element on row "3" and column "2" and when element get selected show yellow background color

        Then sceanrio successfully performed
    # @run
    Scenario: sucsessfully select element by swiping
        Given user is on jquery home page
        And user go to "Selectable" page
        And user go to "Display as grid" page

        Then user choose element on row "1" and column "2" until row "2" and column "1"
        Then validate if selected elements had orange background
