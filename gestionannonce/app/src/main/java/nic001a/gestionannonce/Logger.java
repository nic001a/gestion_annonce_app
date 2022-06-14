package nic001a.gestionannonce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                login_();
            }
        });

    }


    protected void login_() {
       // if (mail.getText().equals("admin@seller.com") && password.getText().equals(("admin"))) {
            Intent intent = new Intent(this, Editor.class);
            startActivity(intent);
      //  }
    }
}
