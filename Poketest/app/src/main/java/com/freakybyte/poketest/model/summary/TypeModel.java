package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class TypeModel {

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("type")
    @Expose
    private TypeDetailModel type;

    /**
     * @return The slot
     */

    public Integer getSlot() {
        return slot;
    }

    /**
     * @param slot The slot
     */
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    /**
     * @return The type
     */
    public TypeDetailModel getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(TypeDetailModel type) {
        this.type = type;
    }
}
