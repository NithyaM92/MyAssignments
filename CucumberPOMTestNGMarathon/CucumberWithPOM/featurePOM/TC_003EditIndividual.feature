Feature: Individual Edit Functionality in salesforce Application

Scenario Outline:Edit individual functionality for valid data
And Enter Username as 'nithyam@testleaf.com'
And Enter Password as 'Welcome@123'
When Click on Login buuton
Then Homepage is displayed
When Click on App launcher icon
And Click on View All link
And Click on Individuals link
And Enter Individual name in search box to edit <IndividualName>
And Choose Edit option for the selected first Individual
Then Edit Individual form opened
Given Choose Salutation as <Saluationoption>
And Enter FirstName as <firstName>
And Click on Save for Edit Action
Then Verify Name changed successfully <firstName>

Examples:
|IndividualName|Saluationoption|firstName|
|SubiV|Mr.|SubiV|
|NithyaM|Mrs.|NithyaM|
|TestT|Mr.|TestT|