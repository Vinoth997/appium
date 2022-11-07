$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\java\\features\\login.feature");
formatter.feature({
  "name": "Bookcart Application Testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Bookcart Application Positive Testing",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "I navigates to the Bookcart application",
  "keyword": "Given "
});
formatter.step({
  "name": "I click on login user",
  "keyword": "And "
});
formatter.step({
  "name": "I enter the \"\u003cUserName\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I click on login button",
  "keyword": "When "
});
formatter.step({
  "name": "Login should be successful",
  "keyword": "Then "
});
formatter.step({
  "name": "I verify the profile name as \"\u003cProfileName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "I can see list of books available",
  "keyword": "And "
});
formatter.step({
  "name": "I close the browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "UserName",
        "Password",
        "ProfileName"
      ]
    },
    {
      "cells": [
        "brucewayne",
        "Bruce000",
        "brucewayne"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Bookcart Application Positive Testing",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "I navigates to the Bookcart application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iNavigatesToTheBookcartApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on login user",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iClickOnLoginUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the \"brucewayne\" and \"Bruce000\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iEnterTheUsernameAndPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on login button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iClickOnLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.loginShouldBeSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the profile name as \"brucewayne\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.verifyProfileName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can see list of books available",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.listOfBooks()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.closeBrowser()"
});
formatter.result({
  "status": "passed"
});
});