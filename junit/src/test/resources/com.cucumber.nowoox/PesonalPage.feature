Feature: I can operate with personal data

  @Smoke@Sometag
  Scenario: I can get my courses
    Given I login on site
    When I open personal data page
    And I go to my courses page
    Then Courses are empty

  @Sometag
  Scenario:  I can get discount
    Given I login on site
    When I open personal data page
    And I open page take friend
    And I send invitation
    Then I get message invitation is sent

  @Sometag
  Scenario: I can change notifications
    Given I login on site
    When I open personal data page
    And I open settings page
    And I go to notifications
    And I change notifications settings
    Then I get popup changes are saved

  @Sometag@Parametrized
  Scenario Outline: I check my accounts
    Given I login on site
    When I open personal data page
    And I open settings page
    When I check "<account>" and value is "<value>"
    Examples:
      | account    | value       |
      | Facebook   | Не привязан |
      | ВКонтакте  | Не привязан |
      | Github     | Не привязан |

  @Smoke@Sometag
  Scenario: I check my posts
    Given I login on site
    And I open personal data page
    When I open my posts page
    Then I get message no posts

  @Sometag
  Scenario: I can check my archive notifications
    Given I login on site
    When I open personal data page
    And I go to notifications archive
    Then I get message no archive notifications

  @Sometag
  Scenario: I can check pwd validation
    Given I login on site
    When I open personal data page
    And I open settings page
    And I type new short pwds
    And I click save password button
    Then I get message pwd is bad

  @Sometag
  Scenario: I can check sms code validation
    Given I login on site
    When I open personal data page
    And I input wrong phone number validation sms
    Then I get message code is wrong

  @Sometag
  Scenario: I cannot submit application
    Given I login on site
    When I select testing page
    And I go to submit qa lead course
    Then I get message I have to register

  @Sometag
  Scenario: I can logout
    Given I login on site
    When I logout site
    Then I can see login button