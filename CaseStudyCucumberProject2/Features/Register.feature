@FunctionalTest
Feature: To Test Register Functionality

@SmokeTest
Scenario: Registration Functionality
Given User is on TestMeApp Page
When User enters "<user>" and "<fname>" and "<lname>" and "<pass>" and "<cpass>" and "<email>" and "<phno>" and "<dob>" and "<address>" and "<ans>"
| katie265 | Khyatee | Thakkar | test02 | test02 | kate@gmail.com | 9876543201 | 05/26/1997 | Flat 3B, Akola | Rourkela |
Then Select Register button
And Display Message Registered Successfully
