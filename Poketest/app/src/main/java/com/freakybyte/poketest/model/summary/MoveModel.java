package com.freakybyte.poketest.model.summary;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class MoveModel {

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetailModel> versionGroupDetails = new ArrayList<>();
    @SerializedName("move")
    @Expose
    private MoveDetailModel move;

    /**
     * @return The versionGroupDetails
     */
    public List<VersionGroupDetailModel> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    /**
     * @param versionGroupDetails The version_group_details
     */
    public void setVersionGroupDetails(List<VersionGroupDetailModel> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    /**
     * @return The move
     */
    public MoveDetailModel getMove() {
        return move;
    }

    /**
     * @param move The move
     */
    public void setMove(MoveDetailModel move) {
        this.move = move;
    }
}
