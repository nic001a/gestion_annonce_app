package nic001a.gestionannonce;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Editor extends AppCompatActivity {

    Button insert, view, update, delete;
    EditText name, phone, date, mail;
    dbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.contact);
        date = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new dbHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = phone.getText().toString();
                String dobTXT = date.getText().toString();
                String mailTXT = mail.getText().toString();

                Boolean checkinsertdata = DB.insertData(nameTXT, contactTXT, dobTXT, mailTXT);
                if (checkinsertdata == true)
                    Toast.makeText(Editor.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Editor.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        ///
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = phone.getText().toString();
                String dobTXT = date.getText().toString();
                String mailTXT = mail.getText().toString();

                Boolean checkupdatedata = DB.updateData(nameTXT, contactTXT, dobTXT,mailTXT);
                if (checkupdatedata == true)
                    Toast.makeText(Editor.this, "Données mise à jour", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Editor.this, "Données non mise à jour", Toast.LENGTH_SHORT).show();
            }
        });

        ////
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deleteData(nameTXT);
                if (checkudeletedata == true)
                    Toast.makeText(Editor.this, "Données suprimés", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Editor.this, "Données non suprimés", Toast.LENGTH_SHORT).show();
            }
        });

        ////

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getData();
                if (res.getCount() == 0) {
                    Toast.makeText(Editor.this, "ID non existant", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name :" + res.getString(0) + "\n");
                    buffer.append("Contact :" + res.getString(1) + "\n");
                    buffer.append("Description :" + res.getString(2) + "\n\n");
                    buffer.append("email :" + res.getString(3) + "\n\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Editor.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }


}