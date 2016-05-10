package com.example.lenovo.assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Fragment3 extends Fragment {







    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


       MyAdapter myAdapter = new MyAdapter(getDataset());

        recyclerView.setAdapter(myAdapter);










        return view;
    }

    private ArrayList<ItemForRecyclerView> getDataset()
    {
        ArrayList result = new ArrayList<ItemForRecyclerView>();

        ItemForRecyclerView obj = new ItemForRecyclerView("Yuvi is the Great player for india. He is just have lot of record for India","7:30 PM",R.drawable.nat);
        result.add(obj);
        ItemForRecyclerView obj1 = new ItemForRecyclerView("Yuvi is the Great Human being. He gives lot of many for our country to help for cancer patient"  ,"5:30 PM",R.drawable.nat);
        result.add(obj1);
        ItemForRecyclerView obj2 = new ItemForRecyclerView("Yuvi is the Great T20 player for india.He also made lot of record in T20 and ODI cricket" ,"3:30 PM",R.drawable.nat);
        result.add(obj2);
        ItemForRecyclerView obj3 = new ItemForRecyclerView("Yuvi have lot of proud moment for Indian cricket History "  ,"2:30 PM",R.drawable.nat);
        result.add(obj3);
        ItemForRecyclerView obj4 = new ItemForRecyclerView("Yuvi gives lot of many for our country to help Indian Cricket And other Games "  ,"12:30 PM",R.drawable.nat);
        result.add(obj4);
        ItemForRecyclerView obj5 = new ItemForRecyclerView(" Sachin  is the Great Player for our Indian Cricket.He is a good Planner"  ,"11:30 PM",R.drawable.nat);
        result.add(obj5);
        ItemForRecyclerView obj8 = new ItemForRecyclerView("Sachin is the Great Human Being.He gives lot of many for our country to help for cancer patient"  ,"9:30 PM",R.drawable.nat);
        result.add(obj8);
        ItemForRecyclerView obj6 = new ItemForRecyclerView("Sachin is the Great Father.He gives lot of happiness for our country"   ,"8:33 AM",R.drawable.nat);
        result.add(obj6);
        ItemForRecyclerView obj7 = new ItemForRecyclerView("Sachin  gives lot of confidence to his teammates.He is a leader of Indian Cricket History"  ,"10:30 PM",R.drawable.nat);
        result.add(obj7);

        return result;
    }


}
