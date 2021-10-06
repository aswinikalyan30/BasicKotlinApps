package com.example.bankingapp_miniproj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR UNIQUE NOT NULL,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9663381937,'Meenakshi',15000.00,'16minukalyan@gmail.com','1234567890','ABC098765400')");
        db.execSQL("insert into user_table values(9881345285,'Aswini',10582.67,'aswinikalyan30@gmailcom','1234567891','ABC098765400')");
        db.execSQL("insert into user_table values(9023884219,'Abhishek',1359.56,'abhishek@gmail.com','1234567892','ABC098765400')");
        db.execSQL("insert into user_table values(8210428843,'Arjun',12000.00,'arjun8181@gmail.com','1234567893','ABC098765400')");
        db.execSQL("insert into user_table values(9143299832,'Aditi ',7603.48,'aditisudhakar@gmail.com','1234567894','ABC098765400')");
        db.execSQL("insert into user_table values(9519932064,'Ashwin',9405.16,'ashwin1606@gmail.com','1234567895','ABC098765400')");
        db.execSQL("insert into user_table values(7100247210,'Praveen',5936.00,'praveen1307@gmail.com','1234567896','ABC098765400')");
        db.execSQL("insert into user_table values(9111234563,'Aditya',857.22,'pradadi@gmail.com','1234567897','ABC098765400')");
        db.execSQL("insert into user_table values(9320021832,'Aman',4798.46,'amankaman@gmail.com','1234567898','ABC098765400')");
        db.execSQL("insert into user_table values(7202566831,'Loki',2073.90,'lokiodinson@gmail.com','1234567899','ABC098765400')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
