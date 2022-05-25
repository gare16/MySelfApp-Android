package com.apps.uts10119911myselfapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.apps.uts10119911myselfapp.HomeActivity;
import com.apps.uts10119911myselfapp.databinding.ActivitySendmailBinding;

public class SendMail extends AppCompatActivity {
    ActivitySendmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailAddress.getText().toString();
                String subject = binding.subjectInput.getText().toString();
                String message = binding.messageInput.getText().toString();

                String[] addresses = email.split(",");

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto: "));
                i.putExtra(Intent.EXTRA_EMAIL, addresses);
                i.putExtra(Intent.EXTRA_SUBJECT, subject);
                i.putExtra(Intent.EXTRA_TEXT, message);

                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }else {
                    Toast.makeText(SendMail.this, "No App is Installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SendMail.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
