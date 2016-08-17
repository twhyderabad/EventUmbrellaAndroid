package com.thoughtworks.eventsumbrella;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivityFragment extends Fragment {
    // EventAdapter eventAdapter;
    List<String> eventUpdate;
    ArrayAdapter<String> eventAdapter;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);


        eventUpdate = new ArrayList<String>(new ArrayList<String>());
        ListView listView = (ListView) rootView.findViewById(R.id.textView);


        eventAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.list_item_events,
                        R.id.list_item_textview,
                        eventUpdate);
        listView.setAdapter(eventAdapter);
        FetchEvents fetchEvents = new FetchEvents(this);
        fetchEvents.execute();
        return rootView;
    }
}
