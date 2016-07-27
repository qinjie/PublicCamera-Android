package edu.np.ece.publiccamera.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Link self;

    @SerializedName("next")
    @Expose
    private Link next;

    @SerializedName("last")
    @Expose
    private Link last;

    /**
     * @return The self
     */
    public Link getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getLast() {
        return last;
    }

    public void setLast(Link last) {
        this.last = last;
    }
}