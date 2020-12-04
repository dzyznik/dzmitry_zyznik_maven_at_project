Feature: TestQA

  Scenario: Submit text form
    Given I go to Text Box
    When I provide Full Name
    When I provide Email
    When I provide Current Address
    When I provide Permanent Address
    When I click Submit button
    Then I verify that it submitted

  Scenario: Select checkboxes
    Given I go to Checkbox
    When I expand all folders
    Then I check 2 flags
    Then I verify marked checkboxes

  Scenario: Select radio button
    Given I go to Radio Buttons
    When I select yes Radio Button
    Then I verify selected Radio Button

  Scenario: Updating web table
    Given I go to Web table
    When I click edit button
    When I edit First Name
    When I edit Last Name
    When I edit Email
    When I edit Age
    When I edit Salary
    When I edit Department
    Then I verify changes

  Scenario: Click all buttons
    Given I go to Buttons
    When I double click button
    When I right click button
    When I just click button
    Then I verify all buttons were clicked

