package com.freakybyte.poketest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class AllPokeModel {

    @SerializedName("count")
    @Expose
    private long count;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<PokeModel> results = new ArrayList<>();
    @SerializedName("next")
    @Expose
    private String next;

    /**
     * No args constructor for use in serialization
     */
    public AllPokeModel() {
    }

    /**
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public AllPokeModel(long count, Object previous, List<PokeModel> results, String next) {
        this.count = count;
        this.previous = previous;
        this.results = results;
        this.next = next;
    }

    /**
     * @return The count
     */
    public long getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(long count) {
        this.count = count;
    }

    public AllPokeModel withCount(long count) {
        this.count = count;
        return this;
    }

    /**
     * @return The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     * @param previous The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public AllPokeModel withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    /**
     * @return The results
     */
    public List<PokeModel> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<PokeModel> results) {
        this.results = results;
    }

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }
}