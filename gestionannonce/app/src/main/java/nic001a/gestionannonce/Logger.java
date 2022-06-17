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
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Logger.this, "Login successful", Toast.LENGTH_SHORT).show();
                login_();
                //if (mail.toString().isEmpty() && password.toString().isEmpty()) {
                // Toast.makeText(Logger.this, "Merci d'entrer vos information pour vous connecter", Toast.LENGTH_SHORT).show();
            }
            // if (login_() == true) {


            //}

            //}
        });

    }

    protected void login_() {
        Intent intent = new Intent(this, Editor.class);
        startActivity(intent);
        //if (mail.getText().equals("admin") && password.getText().equals(("admin"))) {

        //  return true;
        //} else {
        //    return false;
        //}
    }
}


