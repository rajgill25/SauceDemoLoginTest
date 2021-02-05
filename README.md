Test Scenarios For LoginPage:
1 Verify if a user will be able to login with a valid username and valid password. - verify     user reaches application - loginwithvalidcredentials
2 Verify if a user cannot login with a valid username and an invalid password - Epic sadface: Username and password do not match any user in this service- loginwithinvalidcredentials
3Verify if a user cannot login with a invalid username and an invalid password - Epic sadface: Username and password do not match any user in this service - loginwithinvalidcredentials
4 Verify the login page for when the field is blank and Submit button is clicked. - Epic sadface: Username is required - Login with blank fields
5 Verify if a user is locked- Epic sadface: Sorry, this user has been locked out. : Login with locked user
6 Login with problem_user : Verity inside application images are missing
7 Login with performance_glitch_user - use thread
Verify if the data in password field is either visible as asterisk or bullet signs.
Verify if the login page allows to log in simultaneously with different credentials in a different browser
Verify if the font, text color, and color coding of the Login page is as per the standard.
Verify the time taken to log in with a valid username and password.
This project automate few loginpage tests as per different test scenarios.

Technology/Framework Used:Selenium,testNG,Listeneres,Java,maven

How To run Test:open file with path as:src\test\java\testcases\LoginPageTestCases.java
Right click and select run as TestNG test.
For capturing screenshots on test failure,Listener class implementing ITESTLISTENER has been used and image fiels are stored in resource folder with filename same as testmethod name in case of tets failure.

TestNG Data provider annotations have been used to provide data data to test method name.

PageObject repository approach has been used for creating framework where Login page objects are stored in  class named LoginPage and drivers initialisation method and screenshot path method are created in base class.