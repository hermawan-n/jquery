Feature: to choose and validate text inside accordion
    @run
    Scenario: successfully choose and validate accordion
        Given user is on jquery home page
        And user go to "Accordion" page

        Then user choose accordion at section "2"
        Then validate text inside accordion at section "2" contains "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna." as text

        Then sceanrio successfully performed