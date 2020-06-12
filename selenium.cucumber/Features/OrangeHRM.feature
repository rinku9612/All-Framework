Feature: OrangeHRM Login

Scenario: Logo Present on Orange HRM homepage
Given Launch chrome
When Redirect to homepage
Then Logo should present
And close chrome