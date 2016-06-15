package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class GameIndexModel {

    @SerializedName("version")
    @Expose
    private VersionModel version;
    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;

    /**
     *
     * @return
     * The version
     */
    public VersionModel getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(VersionModel version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The gameIndex
     */
    public Integer getGameIndex() {
        return gameIndex;
    }

    /**
     *
     * @param gameIndex
     * The game_index
     */
    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }
}
