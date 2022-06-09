package nic001a.gestionannonce;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button GuestButton;
    Button SellerButton;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        GuestButton = findViewById(R.id.buttonSeller);
        GuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        goToSellerActivity();    }
        });

    }

    private void goToSellerActivity(){
        Intent switchActivity = new Intent(this, EditActivity.class);
        startActivity(switchActivity);
    }


}
