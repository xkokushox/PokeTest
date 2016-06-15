package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class AbilityModel {


    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("ability")
    @Expose
    private AbilityDetailModel ability;

    /**
     *
     * @return
     * The slot
     */
    public Integer getSlot() {
        return slot;
    }

    /**
     *
     * @param slot
     * The slot
     */
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    /**
     *
     * @return
     * The isHidden
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     *
     * @param isHidden
     * The is_hidden
     */
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     *
     * @return
     * The ability
     */
    public AbilityDetailModel getAbility() {
        return ability;
    }

    /**
     *
     * @param ability
     * The ability
     */
    public void setAbility(AbilityDetailModel ability) {
        this.ability = ability;
    }

}
