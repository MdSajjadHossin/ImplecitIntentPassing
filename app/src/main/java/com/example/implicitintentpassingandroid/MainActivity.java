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
                dailIntent.setData(Uri.parse("Gp: +00801790561194"));
                startActivity(dailIntent);
            }
        });

    }
}