package edu.neu.madcourse.numad21su_yiwensun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    EditText editText;
    //EditText editTextUrl;
    Button btn;
    RecyclerView recyclerView;
    List<String> listItem = new ArrayList<>();
    //private ArrayList<String> listItem = new ArrayList<>();
    ReviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.nameID);
        //editTextUrl = findViewById(R.id.urlID);
        btn = findViewById(R.id.addID);
        recyclerView = findViewById(R.id.recyclerViewID);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ReviewAdapter((ArrayList<String>) listItem);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                //String url = editTextUrl.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter URL", Toast.LENGTH_SHORT).show();
               // } else if(url.isEmpty()){
                    //Toast.makeText(getApplicationContext(), "Please Enter URL", Toast.LENGTH_SHORT).show();
                } else{
                    try{
                        String string1 = editText.getText().toString();
                        //String string2 = editTextUrl.getText().toString();
                        //listItem.add(string1);
                        //String string = new String(editText.getText().toString() + editTextUrl.getText().toString());
                        //listItem.add(string1);
                        listItem.add(string1);
                        editText.setText("");
                        //editTextUrl.setText("");
                        adapter.notifyItemInserted(listItem.size()-1);
                    }catch (NumberFormatException e){}
                }
            }
        });
    }
}