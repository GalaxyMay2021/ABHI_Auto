Feature: WhatsApp_Web notificaation Test

@Smoketest1
Scenario: Verify Change Language options of WhatsApp_Web.

Given Launch WhatsApp_Web url
When Enter Aditya Birla name in search text box
And Enter option in chat window
Then Auto response should appearing with respect to enter option

@Smoketest2
Scenario: Verify Policy Details options of WhatsApp_Web.

Given User enters Policy Details option in chat window 
When User enters Policy status option in chat window
Then Hyperlink should generated & User navigate to Policy status webpage
