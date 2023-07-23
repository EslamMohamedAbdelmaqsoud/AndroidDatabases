package com.ahmedelzubair.androiddatabases;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateUserActivity extends AppCompatActivity {

    private EditText edtUserId, edtFirstName, edtLastName, edtPassword;
    private Button btnUpdate;
    private TextView tvUsers;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        databaseHelper = DatabaseHelper.getInstance(this);

        initViews();
        setViewsListeners();
        loadUsers();
    }


    private void initViews() {
        edtUserId = findViewById(R.id.edtUserId);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtPassword = findViewById(R.id.edtPassword);
        btnUpdate = findViewById(R.id.btnAdd);
        tvUsers = findViewById(R.id.tvUsers);

    }

    private void setViewsListeners() {

        btnUpdate.setOnClickListener(view -> {
            String userId = edtUserId.getText().toString();
            String firstName = edtFirstName.getText().toString();
            String lastName = edtLastName.getText().toString();
            String password = edtPassword.getText().toString();

            databaseHelper.updateUser(userId, firstName, lastName, password);
            loadUsers();
        });

    }

    private void loadUsers() {
        tvUsers.setText(databaseHelper.getAllUsers());
    }


}