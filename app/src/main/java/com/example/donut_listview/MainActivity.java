package com.example.donut_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Donut> donutList;
    private ListView donutListView;
    private DonutAdapter donutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutListView = findViewById(R.id.donutListView);

        donutList = new ArrayList<>();

        donutList.add(
                new Donut(
                        R.drawable.donut_yellow,
                        "Tasty Donut",
                        "Spicy tasty donut family",
                        10.00
                )
        );
        donutList.add(
                new Donut(
                        R.drawable.tasty_donut,
                        "Pink Donut",
                        "Spicy tasty donut family",
                        20.00
                )
        );
        donutList.add(
                new Donut(
                        R.drawable.green_donut,
                        "Floating Donut",
                        "Spicy tasty donut family",
                        30.00
                )
        );
        donutList.add(
                new Donut(
                        R.drawable.donut_red,
                        "Tasty Donut",
                        "Spicy tasty donut family",
                        40.00
                )
        );



        setActionForSearchBar();

        filterDonut(1);

        Button donutBtn = findViewById(R.id.donutBtn);
        donutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDonut(1);
            }
        });

        Button pinkDonutBtn = findViewById(R.id.pinkDonutBtn);
        pinkDonutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDonut(2);
            }
        });

        Button floatingDonutBtn = findViewById(R.id.floatingBtn);
        floatingDonutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDonut(3);
            }
        });
    }

    private List<Donut> findDonutWithKeyWord(String keyWord){
        List<Donut> donuts = new ArrayList<>();

        for (Donut donut : donutList){
            if (donut.getDonutName().toLowerCase().contains(keyWord.toLowerCase()))
                donuts.add(donut);
        }

        return donuts;
    }

    /**
     * <li>1: All donuts</li>
     * <li>2: Pink donut</li>
     * <li>3: Floating donut</li>
     * @param donutType
     */
    private void filterDonut(int donutType){
        List<Donut> foundDonuts = new ArrayList<>();

        if (donutType == 1){
            foundDonuts.addAll(donutList);
        }
        else if (donutType == 2){
            foundDonuts.addAll(findDonutWithKeyWord("Pink"));
        }
        else if (donutType == 3){
            foundDonuts.addAll(findDonutWithKeyWord("Floating"));
        }

        donutAdapter = new DonutAdapter(this, R.layout.donut_item_custom, foundDonuts);
        donutListView.setAdapter(donutAdapter);

        if (donutType != 1){
            Toast.makeText(getApplicationContext(), "Found " + foundDonuts.size() + " donuts like this", Toast.LENGTH_SHORT).show();
        }
    }

    private void setActionForSearchBar(){
        EditText searchBar = findViewById(R.id.searchBar);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String keyWord = charSequence.toString();

                if (keyWord.isEmpty()){
                    filterDonut(1);
                }
                else{
                    donutListView.setAdapter(new DonutAdapter(
                            getApplicationContext(),
                            R.layout.donut_item_custom,
                            findDonutWithKeyWord(keyWord)
                    ));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}