package com.thoughtworks.eventsumbrella;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FetchEvents extends AsyncTask<Void, Void, String[]> {
    Call<List<Event>> call;
    private MainActivityFragment mainActivityFragment;
    static String[] event;
    static String[] author;
    static String[] date;

    public FetchEvents(MainActivityFragment mainActivityFragment) {
        this.mainActivityFragment = mainActivityFragment;
    }

    @Override
    protected String[] doInBackground(Void... params) {
        try {

           // String baseUrl = "http://10.0.3.2:8080/events/";
                       String baseUrl = "http://localhost:8080/events/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            EventsUrl service = retrofit.create(EventsUrl.class);
            call = service.getUser();
            Response<List<Event>> response = call.execute();

            event = new String[response.body().size()];
            author = new String[response.body().size()];
            date = new String[response.body().size()];
            for (int i = 0; i < response.body().size(); i++) {
                event[i] = response.body().get(i).getEventTitle();
                author[i] = response.body().get(i).getEventSpeaker();
                date[i] = response.body().get(i).getEventDate();
            }
            return event;
        } catch (Exception e) {
            Log.e("Error", "Error ", e);
            return null;
        } finally {
            call.cancel();
        }
    }

    @Override
    protected void onPostExecute(String[] result) {
        super.onPostExecute(result);
        for (int i = 0; i < event.length; i++) {
            mainActivityFragment.eventName.add(event[i]);
            mainActivityFragment.eventAuthor.add(author[i]);
            mainActivityFragment.eventDate.add(date[i]);
        }
        mainActivityFragment.eventAdapter.notifyDataSetChanged();

    }
}
