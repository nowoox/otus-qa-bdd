Feature: I can operate with personal data

  Scenario: I can get my courses
    Given I login on site
    Then I open personal data page
    Then Courses are empty