package nic001a.gestionannonce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button GuestButton;
    Button SellerButton;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        SellerButton = findViewById(R.id.buttonSeller);
        SellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSellerActivity();
            }
        });

        GuestButton = findViewById(R.id.buttonGuest);
        GuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBuyerActivity();
            }
        });

    }

    //END OF ON_CREATE

    private void goToSellerActivity() {
        Intent switchActivity = new Intent(this, Logger.class);
        startActivity(switchActivity);
    }

    private void goToBuyerActivity() {
        Intent switchActivity = new Intent(this, ViewAd.class);
        startActivity(switchActivity);
    }

}
