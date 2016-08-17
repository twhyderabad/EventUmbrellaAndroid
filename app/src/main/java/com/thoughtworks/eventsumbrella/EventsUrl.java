package com.thoughtworks.eventsumbrella;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventsUrl {
    @GET("?")
    Call<List<Event>> getUser();
}
