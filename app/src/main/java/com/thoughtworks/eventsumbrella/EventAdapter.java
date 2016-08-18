package com.thoughtworks.eventsumbrella;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends BaseAdapter {
    private Context mContext;
    private List eventList = new ArrayList();
    private List authorList = new ArrayList();
    private List dateList = new ArrayList();

    public EventAdapter(Context c, ArrayList<String> eventList, ArrayList<String> authorList, ArrayList<String> datetList) {
        mContext = c;
        this.eventList = eventList;
        this.authorList = authorList;
        this.dateList = datetList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        TextView eventName;
        TextView eventAuthor;
        TextView eventDate;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.list_item_events, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.eventName = (TextView) convertView.findViewById(R.id.list_item_eventname);
            viewHolder.eventAuthor = (TextView) convertView.findViewById(R.id.list_item_eventauthor);
            viewHolder.eventDate = (TextView) convertView.findViewById(R.id.list_item_eventdate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.eventName.setText(eventList.get(position).toString());
        viewHolder.eventAuthor.setText(authorList.get(position).toString());
        viewHolder.eventDate.setText(dateList.get(position).toString());
        return convertView;
    }
}
