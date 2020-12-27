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



    
