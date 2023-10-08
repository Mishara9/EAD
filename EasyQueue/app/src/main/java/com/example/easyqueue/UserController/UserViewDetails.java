package com.example.easyqueue.UserController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easyqueue.Auth.Register;
import com.example.easyqueue.R;

public class UserViewDetails extends AppCompatActivity {

    private ImageView profileImage;
    private TextView userNameTextView, emailLabelTextView, emailValueTextView,
            mobileLabelTextView, mobileValueTextView,
            nicLabelTextView, nicValueTextView,
            addressLabelTextView, addressValueTextView;
    private Button goEdit;
    private User user; // User object to store user's data
    String UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_prof);

        // Initialize views
        profileImage = findViewById(R.id.profile_image);
        userNameTextView = findViewById(R.id.user_name);
        emailLabelTextView = findViewById(R.id.email_label);
        emailValueTextView = findViewById(R.id.email_value);
        mobileLabelTextView = findViewById(R.id.mobile_label);
        mobileValueTextView = findViewById(R.id.mobile_value);
        nicLabelTextView = findViewById(R.id.nic_label);
        nicValueTextView = findViewById(R.id.nic_value);
        goEdit = findViewById(R.id.update_button);

        User user = (User) getIntent().getSerializableExtra("user");

        userNameTextView.setText(user.getFname()+" "+ user.getLname());
        emailValueTextView.setText(user.getEmail());
        mobileValueTextView.setText(user.getMobileNo());
        nicValueTextView.setText(user.getNic());

        goEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = user.getId();
                Intent intent = new Intent(UserViewDetails.this, UserEditDetails.class);
                intent.putExtra("id", userId);
                startActivity(intent);
            }
        });
    }
}
