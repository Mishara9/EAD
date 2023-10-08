package com.example.easyqueue.ReservationController;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easyqueue.DBHelper.DBHelper;
import com.example.easyqueue.R;

public class ResEditDetails extends AppCompatActivity {

    private EditText editTname, editTnic, editTrain, editPlatform, editDate, editTime, editDestination;
    private Button updateButton1;
    private DBHelper dbHelper;

    @Override
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate1(savedInstanceState);
        setContentView(R.layout.activity_reservation_edit);

        // Initialize UI elements
        editTname = findViewById(R.id.edit_tname);
        editTnic = findViewById(R.id.edit_tnic);
        editTrain = findViewById(R.id.edit_train);
        editPlatform = findViewById(R.id.edit_platform);
        editDate = findViewById(R.id.edit_date);
        editTime = findViewById(R.id.edit_time);
        editDestination = findViewById(R.id.edit_destination);
        updateButton1 = findViewById(R.id.update_button1);

        // Retrieve the email from the Intent
        String Tid = getIntent().getStringExtra("tid");

        // Initialize DBHelper
        dbHelper = new DBHelper(this);

        // Fetch user details based on the email from the database
        Reservation currentReservation = dbHelper.getReservationById(Tid);

        // Check if the user was found
        if (currentReservation != null) {
            // Populate the input fields with the current user data
            editTname.setText(currentReservation.getTname());
            editTnic.setText(currentReservation.getTnic());
            editTrain.setText(currentReservation.getTrain());
            editPlatform.setText(currentReservation.getPlatform());
            editDate.setText(currentReservation.getDate());
            editTime.setText(currentReservation.getTime());
            editDestination.setText(currentReservation.getDestination());
        } else {

            Toast.makeText(this, "Reservation not found.", Toast.LENGTH_SHORT).show();
        }

        // Set an OnClickListener for the updateButton
        updateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the update logic here
                updateReservationInfo(currentReservation);
            }
        });
    }

    // Implement the updateUserInfo method to update user information in the database
    private void updateReservationInfo(Reservation currentreservation) {
        String newTname = editTname.getText().toString();
        String newTnic = editTnic.getText().toString();
        String newTrain = editTrain.getText().toString();
        String newPlatform = editPlatform.getText().toString();
        String newDate = editDate.getText().toString();
        String newTime = editTime.getText().toString();
        String newDestination = editDestination.getText().toString();

        // Check if any of the fields are empty (you can add more validation as needed)
        if (TextUtils.isEmpty(newTname) || TextUtils.isEmpty(newTnic) || TextUtils.isEmpty(newTrain) || TextUtils.isEmpty(newPlatform) || TextUtils.isEmpty(newDate) || TextUtils.isEmpty(newTime) || TextUtils.isEmpty(newDestination)) {
            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
            return; // Exit without updating if any field is empty
        }

        // Create or open the SQLite database
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // Create a ContentValues object to store the new values
        ContentValues values = new ContentValues();
        values.put(DBHelper.Column_Tname, newTname);
        values.put(DBHelper.Column_Tnic, newTnic);
        values.put(DBHelper.Column_Train, newTrain);
        values.put(DBHelper.Column_Platform, newPlatform);
        values.put(DBHelper.Column_Date, newDate);
        values.put(DBHelper.Column_Time, newTime);
        values.put(DBHelper.Column_Destination, newDestination);

        // Specify the WHERE clause to identify the row to update (e.g., by user ID)
        String whereClause = DBHelper.Column_TID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(currentrservation.getTid())};

        // Update the user information in the database
        int rowsUpdated = database.update(DBHelper.TABLE_NAME1, values, whereClause, whereArgs);

        // Close the database connection
        database.close();

        // Check if the update was successful
        if (rowsUpdated > 0) {
            Toast.makeText(this, "Booking updated successfully.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ResEditDetails.this, ResViewDetails.class);
            startActivity(intent);
            finish(); // Close the current activity
        } else {
            Toast.makeText(this, "Failed to update Booking. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
