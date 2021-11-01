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

@@Smoketest3
Scenario: Verify Policy Kit options of WhatsApp_Web.

Given User enters Policy kit option in chat window 
Then Allow user to download Policy kit pdf file

@@Smoketest4
Scenario: Verify E-card options of WhatsApp_Web.

Given User enters E-card option in chat window 
Then Allow user to download E-card pdf file

@@Smoketest5
Scenario: Verify 80D-Certificate options of WhatsApp_Web.

Given User enters 80D certificate option in chat window 
Then Allow user to download 80D certificate pdf file