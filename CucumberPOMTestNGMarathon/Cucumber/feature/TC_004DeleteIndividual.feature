Feature: Delete Individual functionality of Salesforce Application

Scenario Outline:Delete Individual functionality of an Application
And Enter Username as 'nithyam@testleaf.com'
And Enter Password as 'Welcome@123'
When Click on Login buuton
Then Homepage is displayed
When Click on App launcher icon
And Click on View All link
And Click on Individuals link
And Enter Individual name in search box to delete <IndividualName>
And Choose Delete option for the selected Individual
Then Delete Individual form opened
And Click Delete option
Then Verify Individual deleted successfully <IndividualName>

Examples:
|IndividualName|
|NithyaM|
|SubiV|
|TestT|