package com.thoughtworks.eventsumbrella;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment {
    EventAdapter eventAdapter;
    List<String> eventName;
    List<String> eventAuthor;
    List<String> eventDate;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);
        ButterKnife.inject(this, rootView);

        eventName = new ArrayList<String>(new ArrayList<String>());
        eventAuthor = new ArrayList<String>(new ArrayList<String>());
        eventDate = new ArrayList<String>(new ArrayList<String>());
        eventAdapter = new EventAdapter(getContext(), (ArrayList<String>) eventName, (ArrayList<String>) eventAuthor, (ArrayList<String>) eventDate);

        ListView listView = (ListView) rootView.findViewById(R.id.textView);
        listView.setAdapter(eventAdapter);
        FetchEvents fetchEvents = new FetchEvents(this);
        fetchEvents.execute();
        return rootView;
    }
}
