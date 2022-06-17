package nic001a.gestionannonce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Logger extends AppCompatActivity {

    Button login_button;
    EditText mail;
    EditText password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        login_button = findViewById(R.id.Login_button);
        mail = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailTXT = mail.getText().toString();
                String passTXT = password.getText().toString();

                if (mailTXT.equals("admin") && passTXT.equals("admin")) {
                    Toast.makeText(Logger.this, "Login successful", Toast.LENGTH_SHORT).show();
                    login_();
                } else {
                    Toast.makeText(Logger.this, "LOGIN FAILED", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    protected void login_() {
        Intent intent = new Intent(this, Editor.class);
        startActivity(intent);
    }
}


