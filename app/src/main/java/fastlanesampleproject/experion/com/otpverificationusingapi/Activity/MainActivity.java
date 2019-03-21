package fastlanesampleproject.experion.com.otpverificationusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import fastlanesampleproject.experion.com.otpverificationusingapi.R;

public class MainActivity extends AppCompatActivity {
    private TextView mEditTextOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextOtp = findViewById(R.id.edit_text_verification_code);
        Intent intent = getIntent();
        String verificationCode = intent.getStringExtra("verificationcode");
        mEditTextOtp.setText(verificationCode);
        mEditTextOtp.requestFocus();

        intitSmsRetrieverClient();

    }

    private void intitSmsRetrieverClient() {
        SmsRetrieverClient client = SmsRetriever.getClient(this);
        Task<Void> task = client.startSmsRetriever();
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("message recived succesfully");

            }
        });
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("message reciving failed");

            }
        });
    }

}
