package com.saurabh.covidcount;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String URL = "https://api.rootnet.in/covid19-in/stats/latest";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mCardAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mCardAdapter = new CardAdapter(getDataSet(),MainActivity.this);
        mRecyclerView.setAdapter(mCardAdapter);
    }

    private ArrayList<CardObject> resultsAll = new ArrayList<>();//Creating list for all cards
    private List<CardObject> getDataSet() {
        resultsAll.clear();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray valuesArray = obj.getJSONObject("data").getJSONArray("regional");
                    for (int i = 0; i < valuesArray.length(); i++) {
                        JSONObject valuesObject = valuesArray.getJSONObject(i);

                        final String location = valuesObject.getString("loc");
                        final int total = valuesObject.getInt("totalConfirmed");
                        final int indian = valuesObject.getInt("confirmedCasesIndian");
                        final int foreign = valuesObject.getInt("confirmedCasesForeign");
                        final int recovered = valuesObject.getInt("discharged");
                        final int deaths = valuesObject.getInt("deaths");
                        final int active = total - recovered - deaths;

                        CardObject card = new CardObject(location,total,indian,foreign,recovered,active,deaths);
                        resultsAll.add(card);
                        mCardAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying the error in toast if occurs
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);

        return resultsAll;
    }
}