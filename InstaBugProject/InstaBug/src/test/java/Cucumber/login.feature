Feature: Login

  Background:
    Given I navigate to website

    Scenario Outline: User tries to login with valid data
      Given I entered the "<userName>" and password correctly
      Then Homepage opens successfully
      Examples:
        | userName                |
        | standard_user           |
        | problem_user            |
        | performance_glitch_user |
        | error_user              |
        | visual_user             |

    Scenario: User tries to login with invalid data
      Given I entered using userName "admin" and password "123"
      Then error message appears "Epic sadface: Username and password do not match any user in this service"

    Scenario: User tries to login with valid userName and invalid password
      Given I entered using userName "standard_user" and password "123"
      Then error message appears "Epic sadface: Username and password do not match any user in this service"

    Scenario: User tries to login with invalid userName and valid password
      Given I entered using userName "admin" and password "secret_sauce"
      Then error message appears "Epic sadface: Username and password do not match any user in this service"

    Scenario: Username and password fields are blank
      Given Leave the fields empty and click login
      Then error message appears "Epic sadface: Username is required"

    Scenario: password field is blank
      Given enter username field only "admin"
      And Leave the fields empty and click login
      Then error message appears "Epic sadface: Password is required"

      ##by fail 3ashan by2ra password using properties file
    Scenario: User tries to login with captialized username and correct password
      Given enter username field "STANDARD_USER" and password
      Then error message appears "Epic sadface: Username and password do not match any user in this service"

    Scenario: User tries to login with lockout user
      Given I entered using userName "locked_out_user" and password "secret_sauce"
      Then error message appears "Epic sadface: Sorry, this user has been locked out."
