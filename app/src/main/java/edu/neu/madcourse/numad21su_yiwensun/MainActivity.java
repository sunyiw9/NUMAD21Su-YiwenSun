package edu.neu.madcourse.numad21su_yiwensun;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    }
}