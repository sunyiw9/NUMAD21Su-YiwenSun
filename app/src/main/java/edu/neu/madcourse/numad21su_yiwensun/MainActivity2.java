package edu.neu.madcourse.numad21su_yiwensun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String[] gridValue = new String[]{
            "A", "B", "C", "D", "E", "F"
    };

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //GridView
        GridView gridView = findViewById(R.id.gridViewID);
        TextView textViewForGrid = (TextView) findViewById(R.id.textForGridID);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gridValue);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                text = gridView.getItemAtPosition(i).toString();
                textViewForGrid.setText("Pressed: " + text);
            }
        });

        if(savedInstanceState != null){
            text = savedInstanceState.getString("pressText");
            textViewForGrid.setText("Pressed: " + text);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("pressText", text);
    }
}