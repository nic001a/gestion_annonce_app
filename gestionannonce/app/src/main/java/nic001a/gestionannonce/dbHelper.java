package nic001a.gestionannonce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context) {
        super(context, "Userdata0.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Userdetails(name TEXT primary key,contact TEXT, phone TEXT, mail TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists Userdetails ");
    }

    public boolean insertData(String name, String contact, String phone, String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("phone", phone);
        contentValues.put("mail", mail);
        Long results = db.insert("Userdetails", null, contentValues);
        if (results == -1) {
            return false;
        } else return true;

    }

    public boolean updateData(String name, String contact, String phone, String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("contact", contact);
        contentValues.put("phone", phone);
        contentValues.put("mail", mail);
        Cursor cursor = db.rawQuery("select * from Userdetails where name = ? ", new String[]{name});
        if (cursor.getCount() > 0) {

            int results = db.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (results == -1) {
                return false;
            } else return true;

        } else return false;
    }

    public boolean deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        Cursor cursor = db.rawQuery("select * from Userdetails where name = ? ", new String[]{name});
        if (cursor.getCount() > 0) {

            int results = db.delete("Userdetails", "name=?", new String[]{name});
            if (results == -1) {
                return false;
            } else return true;

        } else return false;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        Cursor cursor = db.rawQuery("select * from Userdetails", null);
        return cursor;

    }
}

