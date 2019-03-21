# Automatic-SMS-Verification-with-the-SMS-Retriever-API

#####  Sample SMS format for testing :smile:
<#> Your ExampleApp code is: 123ABC78 : IYboJyTjBwh


##### Use the above sample SMS message to check the app. 

The last 11 character code is the hash string of the app. Android OS use this hash string to identify the application and broadcast the SMS message to the our app. So that we can receive the SMS  string in our broadcast reciver and can parse the data. 

Generate the 11 character hash code using the helper class (AppSignatureHelper.java), when creating your own application.

**Reference:**
- [Overview][SMS Retriever API Overview]
- [Request SMS Verification][Request SMS verification ]
- [Perform SMS Verification on a Server][Perform SMS Verification on a Server]


[SMS Retriever API Overview]: https://developers.google.com/identity/sms-retriever/overview "SMS Retriever API"
[Request SMS verification ]: https://developers.google.com/identity/sms-retriever/request "SMS Retriever API"
[Perform SMS Verification on a Server]: https://developers.google.com/identity/sms-retriever/verify "SMS Retriever API"
