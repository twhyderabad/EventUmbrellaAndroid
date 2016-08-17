
package com.thoughtworks.eventsumbrella;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("eventSpeaker")
    @Expose
    private String eventSpeaker;
    @SerializedName("eventTitle")
    @Expose
    private String eventTitle;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;
    @SerializedName("eventId")
    @Expose
    private Integer eventId;

    /**
     * 
     * @return
     *     The eventSpeaker
     */
    public String getEventSpeaker() {
        return eventSpeaker;
    }

    /**
     * 
     * @param eventSpeaker
     *     The eventSpeaker
     */
    public void setEventSpeaker(String eventSpeaker) {
        this.eventSpeaker = eventSpeaker;
    }

    /**
     * 
     * @return
     *     The eventTitle
     */
    public String getEventTitle() {
        return eventTitle;
    }

    /**
     * 
     * @param eventTitle
     *     The eventTitle
     */
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    /**
     * 
     * @return
     *     The eventDate
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * 
     * @param eventDate
     *     The eventDate
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * 
     * @return
     *     The eventId
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * 
     * @param eventId
     *     The eventId
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

}
