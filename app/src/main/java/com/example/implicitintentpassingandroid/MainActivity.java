package com.example.implicitintentpassingandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dailBtn, messageBtn, shareBtn, emailBtn;

        dailBtn = findViewById(R.id.dailBtn);
        messageBtn = findViewById(R.id.messageBtn);
        shareBtn = findViewById(R.id.shareBtn);
        emailBtn = findViewById(R.id.emailBtn);


        dailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dailIntent  = new Intent(Intent.ACTION_DIAL);
//                dailIntent.setAction(Intent.ACTION_DIAL);
                dailIntent.setData(Uri.parse("tel: +00801790561194"));
                startActivity(dailIntent);
            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageIntent = new Intent(Intent.ACTION_SENDTO);
                messageIntent.setData(Uri.parse("smsto:"+Uri.encode("+00801790561194")));
                messageIntent.putExtra("sms_body","Write Message Here");
                startActivity(messageIntent);

            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sajjadhossion3749@gmail.com", "sourav3749@gmail.com","tanvirrahman200@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ant Things");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Extra Text");
                startActivity(Intent.createChooser(emailIntent, "Via Email"));

            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Links");
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
            }
        });
    }
}