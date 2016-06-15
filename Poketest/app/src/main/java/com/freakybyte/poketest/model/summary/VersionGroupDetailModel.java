package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class VersionGroupDetailModel {


    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethodModel moveLearnMethod;
    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroupModel versionGroup;

    /**
     * @return The moveLearnMethod
     */
    public MoveLearnMethodModel getMoveLearnMethod() {
        return moveLearnMethod;
    }

    /**
     * @param moveLearnMethod The move_learn_method
     */
    public void setMoveLearnMethod(MoveLearnMethodModel moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    /**
     * @return The levelLearnedAt
     */
    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    /**
     * @param levelLearnedAt The level_learned_at
     */
    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    /**
     * @return The versionGroup
     */
    public VersionGroupModel getVersionGroup() {
        return versionGroup;
    }

    /**
     * @param versionGroup The version_group
     */
    public void setVersionGroup(VersionGroupModel versionGroup) {
        this.versionGroup = versionGroup;
    }
}
