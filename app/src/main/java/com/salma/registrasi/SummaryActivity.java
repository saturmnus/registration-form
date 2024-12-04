package com.salma.registrasi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView textViewNim, textViewName, textViewEmail, textViewPhone, textViewFaculty, textViewMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textViewNim = findViewById(R.id.textViewNim);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewFaculty = findViewById(R.id.textViewFaculty);
        textViewMajor = findViewById(R.id.textViewMajor);

        user user = (user) getIntent().getSerializableExtra("USER_DATA");

        if (user != null) {
            textViewNim.setText(user.getNim());
            textViewName.setText(user.getFullName());
            textViewEmail.setText(user.getEmail());
            textViewPhone.setText(user.getPhone());
            textViewFaculty.setText(user.getFaculty());
            textViewMajor.setText(user.getMajor());

            textViewEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + user.getEmail()));
                    startActivity(emailIntent);
                }
            });

            textViewPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + user.getPhone()));
                    startActivity(phoneIntent);
                }
            });
        }
    }
}
