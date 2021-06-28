package edu.neu.madcourse.numad21su_yiwensun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity5 extends AppCompatActivity {

    Button button;
    EditText inputName;
    String cityLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        button = (Button) findViewById(R.id.getBtnID);
        inputName = (EditText) findViewById(R.id.cityNameID);
        ProgressBar progressBar = new ProgressBar(MainActivity5.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.loadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.dismissDialog();
                    }
                }, 1000);

                RequestQueue queue = Volley.newRequestQueue(MainActivity5.this);
                String url = "https://www.metaweather.com/api/location/search/?query="+inputName.getText().toString();

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject city = response.getJSONObject(0);
                            cityLocation = city.getString("latt_long");
                            Toast.makeText(MainActivity5.this, "City location is: " + cityLocation, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity5.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(request);
            }
        });
    }
}

