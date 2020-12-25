Feature: I can operate with personal data

  Scenario: I can get my courses
    Given I login on site
    When I open personal data page
    Then I go to my courses page
    Then Courses are empty

  Scenario:  I can get discount
    Given I login on site
    Then I open personal data page
    When I open page take friend
    And I send invitation
    Then I get message invitation is sent

  Scenario: I can change