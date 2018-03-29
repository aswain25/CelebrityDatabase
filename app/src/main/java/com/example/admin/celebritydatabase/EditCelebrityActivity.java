package com.example.admin.celebritydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;

public class EditCelebrityActivity extends AppCompatActivity
{

    Celebrity model;
    int modelID;
    EditText etFirstName;
    EditText etLastName;
    EditText etTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_celebrity);


        model = (Celebrity)getIntent().getSerializableExtra("data");
        modelID = getIntent().getIntExtra("id", 0);

        etFirstName = findViewById(R.id.etFirstNameEdit);
        etLastName = findViewById(R.id.etLastNameEdit);
        etTitle = findViewById(R.id.etTitleEdit);

        etFirstName.setText(model.getFirstName());
        etLastName.setText(model.getLastName());
        etTitle.setText(model.getTitle());
    }

    public void btnConfirm_Clicked(View view) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        LocalDataSource<Celebrity> db = new LocalDataSource<Celebrity>(this, "Celebrity", "Id", "INTEGER", new String[]{ "FirstName", "LastName", "Title"}, new String[]{ "TEXT", "TEXT", "TEXT"}, 1);
        Celebrity newCelebrity = new Celebrity(model.getId(), etFirstName.getText().toString(), etLastName.getText().toString(), etTitle.getText().toString());
        db.updatePerson(newCelebrity);
        Intent intent = new Intent(getApplicationContext(), ViewCelebritiesActivity.class);
        startActivity(intent);
    }
    public void btnCancel_Clicked(View view)
    {

        Intent intent = new Intent(getApplicationContext(), ViewCelebritiesActivity.class);
        startActivity(intent);
    }
}
