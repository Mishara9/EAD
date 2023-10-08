package com.example.easyqueue.DBHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.easyqueue.UserController.User;

import java.util.UUID;

public class DBHelper extends SQLiteOpenHelper {

    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();

    public static final String DATABASE_NAME = "TicketReservation.db";

    /*-----------------------Uers table------------------------*/
    public static final String TABLE_NAME="User";
    public static final String Column_ID="id";
    public static final String Column_Fname="fname";
    public static final String Column_Lname="lname";
    public static final String Column_Email="email";
    public static final String Column_Mobile="mobileNo";
    public static final String Column_Nic="nic";
    public static final String Column_Password="password";

    /*-----------------------Reservation table------------------------*/

    public static final String TABLE_NAME1="Reservation";
    public static final String Column_TID="tid";
    public static final String Column_Tname="tname";
    public static final String Column_Tnic="tnic";
    public static final String Column_Train="train";
    public static final String Column_Platform="platform";
    public static final String Column_Date="date";
    public static final String Column_Time="time";
    public static final String Column_Destination="destination";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    /*-----------------------User functions------------------------*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +" ("+Column_ID+" INTEGER PRIMARY KEY, " +Column_Fname+" VARCHAR," +Column_Lname+" VARCHAR, " +Column_Email+" VARCHAR, " +Column_Mobile+" VARCHAR, " +Column_Nic+" VARCHAR, " +Column_Password+" VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @SuppressLint("Range")
    public User getUserById(String id) {
        User user = null;
        SQLiteDatabase database = this.getReadableDatabase();

        // Define the columns you want to retrieve
        String[] columns = {
                Column_ID,
                Column_Fname,
                Column_Lname,
                Column_Email,
                Column_Mobile,
                Column_Nic,
                Column_Password
        };

        // Define the selection criteria (WHERE clause)
        String selection = Column_ID + " = ?";
        String[] selectionArgs = {id};

        // Query the database
        Cursor cursor = database.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            user = new User(
                    cursor.getString(cursor.getColumnIndex(Column_ID)),
                    cursor.getString(cursor.getColumnIndex(Column_Fname)),
                    cursor.getString(cursor.getColumnIndex(Column_Lname)),
                    cursor.getString(cursor.getColumnIndex(Column_Email)),
                    cursor.getString(cursor.getColumnIndex(Column_Mobile)),
                    cursor.getString(cursor.getColumnIndex(Column_Nic)),
                    cursor.getString(cursor.getColumnIndex(Column_Password))
            );
            cursor.close();
        }

        return user;
    }
    /*-----------------------Resevation functions------------------------*/
    @Override
    public void onCreate1(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE1="CREATE TABLE IF NOT EXISTS "+ TABLE_NAME1 +" ("+Column_TID+" INTEGER PRIMARY KEY, " +Column_Tname+" VARCHAR," +Column_Tnic+" VARCHAR, " +Column_Train+" VARCHAR, " +Column_Platform+" VARCHAR, " +Column_Date+" VARCHAR, " +Column_Time+" VARCHAR, " +Column_Destination+" VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE1);
    }

    @Override
    public void onUpgrade1(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate1(sqLiteDatabase);
    }

    @SuppressLint("Range")
    public Reservation getReservationById(String tid) {
        Reservation reservation = null;
        SQLiteDatabase database = this.getReadableDatabase();

        // Define the columns you want to retrieve
        String[] columns = {
                Column_TID,
                Column_Tname,
                Column_Tnic,
                Column_Train,
                Column_Platform,
                Column_Date,
                Column_Time,
                Column_Destination
        };

        // Define the selection criteria (WHERE clause)
        String selection = Column_TID + " = ?";
        String[] selectionArgs = {tid};

        // Query the database
        Cursor cursor1 = database.query(TABLE_NAME1, columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            reservation = new Reservation(
                    cursor.getString(cursor.getColumnIndex(Column_TID)),
                    cursor.getString(cursor.getColumnIndex(Column_Tname)),
                    cursor.getString(cursor.getColumnIndex(Column_Tnic)),
                    cursor.getString(cursor.getColumnIndex(Column_Train)),
                    cursor.getString(cursor.getColumnIndex(Column_Platform)),
                    cursor.getString(cursor.getColumnIndex(Column_Date)),
                    cursor.getString(cursor.getColumnIndex(Column_Time)),
                    cursor.getString(cursor.getColumnIndex(Column_Destination))
            );
            cursor.close();
        }

        return user, reservation;
    }
}
