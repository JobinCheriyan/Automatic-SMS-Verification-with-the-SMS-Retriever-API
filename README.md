# Automatic-SMS-Verification-with-the-SMS-Retriever-API

Sample SMS format for testing
<#> Your ExampleApp code is: 123ABC78 : IYboJyTjBwh

Use the above sample SMS message to check the app. 

The last 11 character code is the hash string of the app. Android OS use this hash string to identify the application and broadcast the SMS message to the our app. So that we can receive the SMS  string in our broadcast reciver and can parse the data. 

Generate the 11 character hash code using the helper class (AppSignatureHelper.java), when creating your own application.

Reference: https://developers.google.com/identity/sms-retriever/overview
