package com.example.admin.celebritydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;

public class CreateCelebrityActivity extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    EditText etTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_celebrity);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etTitle = findViewById(R.id.etTitle);
    }

    public void btnConfirm_Clicked(View view) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        LocalDataSource<Celebrity> db = new LocalDataSource<Celebrity>(this, "Celebrity", "Id", "INTEGER", new String[]{"FirstName", "LastName", "Title"}, new String[]{ "TEXT", "TEXT", "TEXT"}, 1);
        Celebrity newCelebrity = new Celebrity(0, etFirstName.getText().toString(), etLastName.getText().toString(), etTitle.getText().toString());
        db.savePerson(newCelebrity);
        Intent intent = new Intent(getApplicationContext(), ViewCelebritiesActivity.class);
        startActivity(intent);
    }

    public void btnCancel_Clicked(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewCelebritiesActivity.class);
        startActivity(intent);
    }
}
