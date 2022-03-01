package com.example.beauty_saloon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    String dbname = "miniproject.db";

    public DbHelper(@Nullable Context context) {
        super(context, "miniproject.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table Registertable(Id Integer primary key autoincrement , Name text , Email text , Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if Exists Registertable");
    }

    public void Registertableinsert(String Name , String Email , String Password){

        // for all function to make a object;

        SQLiteDatabase db = this.getWritableDatabase();

        // for insert value in right table;

        ContentValues insert = new ContentValues();
        insert.put("Name" , Name);
        insert.put("Email" , Email);
        insert.put("Password" , Password);

        // for insert data in table;

        db.insert("Registertable" , null , insert);
    }

    // for Email check;

    public boolean Emailcheck(String emailcheck){

    // for all function to make a object;

      SQLiteDatabase db = this.getWritableDatabase();

    // for finding email from table;

    Cursor findemail = db.rawQuery("Select * From Registertable Where Email = ?" , new String[] {emailcheck});

    // for result

        if (findemail.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean Logincheck(String Email , String Password){

        // for all function to make a object;

        SQLiteDatabase db = this.getWritableDatabase();

        // for finding Login Credential from table;

        Cursor logincheck = db.rawQuery("Select * From Registertable Where Email = ? And Password = ?" , new String[] {Email , Password});

        // for result

        if (logincheck.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }








}
