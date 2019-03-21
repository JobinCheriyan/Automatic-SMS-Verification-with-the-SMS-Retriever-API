package fastlanesampleproject.experion.com.otpverificationusingapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "SMS recived", Toast.LENGTH_SHORT).show();
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);

            switch (status.getStatusCode()) {
                case CommonStatusCodes.SUCCESS:
                    // Get SMS message contents
                    String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                    // Extract one-time code from the message and complete verification
                    // by sending the code back to your server.
                    String verificationCode = getVerificationCode(message);
                    Intent passVerificationCodeIntent = new Intent(context, MainActivity.class);
                    passVerificationCodeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    passVerificationCodeIntent.putExtra("verificationcode", verificationCode);
                    context.startActivity(passVerificationCodeIntent);
                    break;
                case CommonStatusCodes.TIMEOUT:
                    // Waiting for SMS timed out (5 minutes)
                    // Handle the error ...
                    break;
            }
        }
    }

    private String getVerificationCode(String message) {
        String verificationCode = null;
        int indexStart = message.indexOf(":");
        int indexEnd = message.indexOf(":", indexStart + 1);

        if (indexEnd != -1) {
            int start = indexStart + 2;
            int end = indexEnd - 2;
            verificationCode = message.substring(start, end);

            return verificationCode;
        }

        return verificationCode;
    }
}
