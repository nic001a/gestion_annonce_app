package nic001a.gestionannonce;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewAd extends AppCompatActivity {
    Button view;
    dbHelper DB;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ad);
        view = findViewById(R.id.btnView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getData();
                if (res.getCount() == 0) {
                    Toast.makeText(ViewAd.this, "ID non existant", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name :" + res.getString(0) + "\n");
                    buffer.append("Contact :" + res.getString(1) + "\n");
                    buffer.append("Description :" + res.getString(2) + "\n\n");
                    buffer.append("email :" + res.getString(3) + "\n\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ViewAd.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}
