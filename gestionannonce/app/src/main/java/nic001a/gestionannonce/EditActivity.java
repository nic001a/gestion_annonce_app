package nic001a.gestionannonce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText Ad_ID, Ad_mail, Ad_phone, Ad_Description;
    private DBHandler dbHandler;
    private Button Add_Ad_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        Ad_ID = findViewById(R.id.idEdtAd_ID);
        Ad_Description = findViewById(R.id.idEdtAdDescription);
        Ad_phone = findViewById(R.id.idEdtAdphone);
        Ad_mail = findViewById(R.id.idEdtAdemail);

        dbHandler = new DBHandler(EditActivity.this);

        Add_Ad_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AdID = Ad_ID.getText().toString();
                String AdPhone = Ad_phone.getText().toString();
                String AdMail = Ad_mail.getText().toString();
                String AdDescription = Ad_Description.getText().toString();

                if (AdID.isEmpty() && AdDescription.isEmpty() && AdMail.isEmpty() && AdPhone.isEmpty()) {
                    Toast.makeText(EditActivity.this, "Merci de remplir tout les champs", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewAd(AdID, AdDescription, AdPhone, AdMail);

                Toast.makeText(EditActivity.this, "DONNÉES ENREGISTRÉES", Toast.LENGTH_SHORT).show();
                Ad_ID.setText("");
                Ad_Description.setText("");
                Ad_mail.setText("");
                Ad_phone.setText("");

            }
        });


    }
}