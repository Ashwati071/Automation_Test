# MyStore Automation Framework

This is an automated testing framework for the MyStore web app. It uses the Page Object Model (POM) design pattern for easy maintenance and TestNG as the test runner. The framework automates real user scenarios like registration, login, and logout.

Features covered:

User Registration

User Login

User Logout

Test Data Details:
Registration Data:
User details for registration (first name, last name, email, password) are stored in the config.properties file.
For the email, a unique/random value is generated during runtime to avoid duplicate user registration errors.

Login Credentials:
Login email and password are also fetched from the config.properties file.
