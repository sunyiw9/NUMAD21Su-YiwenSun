package edu.neu.madcourse.numad21su_yiwensun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button clicked
        Button btn = (Button) findViewById(R.id.btnID);
        TextView textView = (TextView) findViewById(R.id.textID);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Yiwen Sun: sun.yiw@northeastern.edu");
            }
        });

        //Button to grid
        Button buttonToGrid = (Button) findViewById(R.id.buttonGridID);

        buttonToGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        //Link Collector Button
        Button linkBtn = (Button) findViewById(R.id.linkCollectorID);

        linkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity3();
            }
        });

        //Get Location Button
        Button locationBtn = (Button) findViewById(R.id.locationID);

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity4();
            }
        });
    }

    public void openMainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openMainActivity3(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void openMainActivity4(){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}