package com.enterprises.wayne.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private ListView mListViewNumbers;
    private ArrayAdapter<String> mAdapterNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // generate random data
        List<String> randomData = getRandomData(20);

        // setup the adapter
        mAdapterNumbers = new ArrayAdapter<String>(
                this
                , R.layout.row_number
                , R.id.text_view_number
                , randomData
        );

        // reference the list view
        mListViewNumbers = (ListView) findViewById(R.id.list_view_numbers);

        // bind the adapter to the list view
        mListViewNumbers.setAdapter(mAdapterNumbers);
    }

    /**
     * fills an array of the specified size with random numbers from 1 to 1000
     */
    private List<String> getRandomData(int size)
    {
        Random random = new Random();
        List<String> result = new LinkedList<>();
        for (int i = 0; i < size; i++)
            result.add((random.nextInt(1000) + 1) + "");
        return result;
    }
}
