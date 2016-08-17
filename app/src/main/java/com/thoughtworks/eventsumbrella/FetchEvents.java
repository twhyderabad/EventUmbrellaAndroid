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

    public FetchEvents(MainActivityFragment mainActivityFragment) {
        this.mainActivityFragment = mainActivityFragment;
    }

    @Override
    protected String[] doInBackground(Void... params) {
        try {

//            String baseUrl = "http://10.0.3.2:8080/events/";
            String baseUrl = "http://localhost:8080/events/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            EventsUrl service = retrofit.create(EventsUrl.class);
            call = service.getUser();
            Response<List<Event>> response = call.execute();

            String[] mStringArray = new String[response.body().size()];
            for (int i = 0; i < response.body().size(); i++) {
                mStringArray[i] = response.body().get(i).getEventTitle() + "-" + response.body().get(i).getEventSpeaker() + "-" + response.body().get(i).getEventDate();
            }
            return mStringArray;
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
        mainActivityFragment.eventAdapter.clear();
        for (String strs : result) {
            mainActivityFragment.eventAdapter.add(strs);
        }
    }
}
