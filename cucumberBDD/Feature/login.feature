Feature: Login
Scenario: successfull login with valid credentials
Given user launch browser
When url of gmail
And input username and password
Then homepage displayed
And close browser


