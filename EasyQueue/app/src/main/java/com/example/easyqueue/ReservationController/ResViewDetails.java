package com.example.easyqueue.ReservationController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easyqueue.Auth.Register;
import com.example.easyqueue.R;

public class ResViewDetails extends AppCompatActivity {

    //private ImageView profileImage;
    private TextView tnameLabelTextView, tnameValueTextView,
            tnicLabelTextView, tnicValueTextView,
            trainLabelTextView, trainValueTextView,
            platformLabelTextView, platformValueTextView,
            dateLabelTextView, dateValueTextView,
            timeLabelTextView, timeValueTextView,
            destinationLabelTextView, destinationValueTextView;

    private Button goEdit1;
    private Reservation reservation; // Resrvation object to store reservation's data
    //String UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Reservation_View);

        // Initialize views
        //profileImage = findViewById(R.id.profile_image);
        tnameLabelTextView = findViewById(R.id.tname_label);
        tnameValueTextView = findViewById(R.id.tname_value);
        tnicLabelTextView = findViewById(R.id.tnic_label);
        tnicValueTextView = findViewById(R.id.tnic_value);
        trainLabelTextView = findViewById(R.id.train_label);
        trainValueTextView = findViewById(R.id.train_value);
        platformLabelTextView = findViewById(R.id.platform_label);
        platformValueTextView = findViewById(R.id.platform_value);
        dateLabelTextView = findViewById(R.id.date_label);
        dateValueTextView = findViewById(R.id.date_value);
        timeLabelTextView = findViewById(R.id.time_value);
        timeValueTextView = findViewById(R.id.time_value);
        destinationLabelTextView = findViewById(R.id.destination_value);
        destinationValueTextView = findViewById(R.id.destination_value);
        goEdit1 = findViewById(R.id.update_button1);

        Reservation reservation = (Reservation) getIntent().getSerializableExtra("reservation");

        tnameValueTextView.setText(reservation.getTname());
        tnicValueTextView.setText(reservation.getTnic());
        trainValueTextView.setText(reservation.getTrain());
        platformValueTextView.setText(reservation.getPlatform());
        dateValueTextView.setText(reservation.getDate());
        timeValueTextView.setText(reservation.getTime());
        destinationValueTextView.setText(reservation.getDestination());


        goEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Tid = reservation.getTid();
                Intent intent = new Intent(ResViewDetails.this, ResEditDetails.class);
                intent.putExtra("tid", Tid);
                startActivity(intent);
            }
        });
    }
}
