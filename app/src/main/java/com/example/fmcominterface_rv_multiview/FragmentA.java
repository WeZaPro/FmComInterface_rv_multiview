package com.example.fmcominterface_rv_multiview;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

//Todo Step 2 ==> Create FM A
public class FragmentA extends Fragment {

    // Set data ArrayList
    // Set Rv Layout
    // Set Adapter
    // set Listener (Interface)
    // onAttact Listener
    // onDetact Listener

    View v;
    MyAdapter myAdapter;
    ArrayList<MyChidModel> listData = new ArrayList<>();
    MyListener listener;
    MyChidModel myChidModel;
    RecyclerView _myRecyclerView;

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // check v = null

        if(v == null){
            v = inflater.inflate(R.layout.fragment_a, container, false);

            setMyRvLayout(v);
            setMyData();
            setMyAdapter();
        }
        return v;
    }

    private void setMyRvLayout(View v) {

        _myRecyclerView = v.findViewById(R.id.myRecyclerView);
        _myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setMyData() {
        double rate[] = {1,2,3,4,5,6,7,8,9};
        int image[] = {R.drawable.brazil,R.drawable.ghana,R.drawable.island,
                R.drawable.japan,R.drawable.polynesia,R.drawable.southkorea,
                R.drawable.spain,R.drawable.unitedkingdom,R.drawable.usa};
        String country[] = {"brazil","ghana","island","japan","polynesia",
                "southkorea","spain","unitedkingdom","usa"};
        int dataSize = rate.length;

        for (int i = 0; i < dataSize; i++) {

            myChidModel = new MyChidModel();

            //myChidModel = new MyChidModel(rate[i],image[i],country[i]);

            myChidModel.setRates(rate[i]);
            myChidModel.setCountryNames(country[i]);
            myChidModel.setImageFlags(image[i]);

            listData.add(myChidModel);
        }
    }

    private void setMyAdapter() {

        myAdapter = new MyAdapter(getActivity(),listData,listener);
        _myRecyclerView.setAdapter(myAdapter);

    }
}
