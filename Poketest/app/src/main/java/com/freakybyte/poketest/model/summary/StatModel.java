package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class StatModel {

    @SerializedName("stat")
    @Expose
    private StatDetailModel stat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;

    /**
     * @return The stat
     */
    public StatDetailModel getStat() {
        return stat;
    }

    /**
     * @param stat The stat
     */
    public void setStat(StatDetailModel stat) {
        this.stat = stat;
    }

    /**
     * @return The effort
     */
    public Integer getEffort() {
        return effort;
    }

    /**
     * @param effort The effort
     */
    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    /**
     * @return The baseStat
     */
    public Integer getBaseStat() {
        return baseStat;
    }

    /**
     * @param baseStat The base_stat
     */
    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

}
