Feature: New Individual creation in saleforce Application

Scenario Outline:: New Individual creation for valid data
And Enter Username as 'nithyam@testleaf.com'
And Enter Password as 'Welcome@123'
When Click on Login buuton
Then Homepage is displayed
When Click on App launcher icon
And Click on View All link
And Click on Individuals link
And click on Individual dropdown in the next page
And click on New Individual option
Then New Individual screen form wil be displayed
Given Enter the Lastname as <Lastname>
When Click on save button
Then Individual created successfully <Lastname>

Examples:
|Lastname|
|NithyaM|
|SubiV|
|TestT|
