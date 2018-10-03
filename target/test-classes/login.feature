#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing login
  As a user
  I want to login to my account
  So I can manage my account

  @tag1
  Scenario: Testing login and registration
    Given the website
    When I click the sign in button
    And I click on Sign up button
    And I fill out the fields with valid credentials
    And I press the sign up button
    And I press sign out
    Then I enter my newly created account details
    And I press the sign in button
