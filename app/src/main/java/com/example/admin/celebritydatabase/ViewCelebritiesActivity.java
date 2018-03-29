package com.example.admin.celebritydatabase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ViewCelebritiesActivity extends AppCompatActivity {

    ListView lvCelebrities;
    List<Celebrity> allCeleb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_celebrities);

        LocalDataSource<Celebrity> db = new LocalDataSource<>(this, "Celebrity", "Id", "INTEGER", new String[]{ "FirstName", "LastName", "Title"}, new String[]{ "TEXT", "TEXT", "TEXT"}, 1);

        allCeleb = new ArrayList<Celebrity>();
        try {
            allCeleb = db.getAllPerson(Celebrity.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] names = new String[allCeleb.size()];
        for (int i = 0; i < names.length; i++)
            names[i] = allCeleb.get(i).firstName + " " + allCeleb.get(i).lastName;

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, names);

        lvCelebrities = findViewById(R.id.lvCelebrities);
        lvCelebrities.setAdapter(adapter);
        lvCelebrities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), EditCelebrityActivity.class);
                intent.putExtra("data", allCeleb.get(position));
                intent.putExtra("id", position);
                startActivity(intent);
                //String item = ((TextView)view).getText().toString();

                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void navigateToCreate(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateCelebrityActivity.class);
        startActivity(intent);
    }
}

