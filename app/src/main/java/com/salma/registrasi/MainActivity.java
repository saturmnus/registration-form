package com.salma.registrasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNim, editTextName, editTextEmail, editTextPhone, editTextMajor;
    private Spinner spinnerFaculty;
    private Button buttonRegister, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNim = findViewById(R.id.editTextNim);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextMajor = findViewById(R.id.editTextMajor);
        spinnerFaculty = findViewById(R.id.spinnerFaculty);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonReset = findViewById(R.id.buttonReset);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.faculties_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFaculty.setAdapter(adapter);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String nim = editTextNim.getText().toString();
                    String name = editTextName.getText().toString();
                    String email = editTextEmail.getText().toString();
                    String phone = editTextPhone.getText().toString();
                    String major = editTextMajor.getText().toString();
                    String faculty = spinnerFaculty.getSelectedItem().toString();

                    user user = new user(nim, name, email, phone, faculty, major);

                    Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                    intent.putExtra("USER_DATA", user);
                    startActivity(intent);
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetInputs();
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(editTextNim.getText())) {
            editTextNim.setError("NIM wajib diisi");
            return false;
        }
        if (TextUtils.isEmpty(editTextName.getText())) {
            editTextName.setError("Nama lengkap wajib diisi");
            return false;
        }
        if (TextUtils.isEmpty(editTextEmail.getText()) || !Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText()).matches()) {
            editTextEmail.setError("Email tidak valid");
            return false;
        }
        if (TextUtils.isEmpty(editTextPhone.getText()) || !editTextPhone.getText().toString().matches("\\d+")) {
            editTextPhone.setError("Phone hanya boleh angka");
            return false;
        }
        if (TextUtils.isEmpty(editTextMajor.getText())) {
            editTextMajor.setError("Jurusan wajib diisi");
            return false;
        }
        return true;
    }

    private void resetInputs() {
        editTextNim.setText("");
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextMajor.setText("");
        spinnerFaculty.setSelection(0);
    }
}
