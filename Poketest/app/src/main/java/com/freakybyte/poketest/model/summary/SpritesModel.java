package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class SpritesModel {


    @SerializedName("back_female")
    @Expose
    private Object backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private Object backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private Object frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private Object frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;

    /**
     * @return The backFemale
     */
    public Object getBackFemale() {
        return backFemale;
    }

    /**
     * @param backFemale The back_female
     */
    public void setBackFemale(Object backFemale) {
        this.backFemale = backFemale;
    }

    /**
     * @return The backShinyFemale
     */
    public Object getBackShinyFemale() {
        return backShinyFemale;
    }

    /**
     * @param backShinyFemale The back_shiny_female
     */
    public void setBackShinyFemale(Object backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    /**
     * @return The backDefault
     */
    public String getBackDefault() {
        return backDefault;
    }

    /**
     * @param backDefault The back_default
     */
    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    /**
     * @return The frontFemale
     */
    public Object getFrontFemale() {
        return frontFemale;
    }

    /**
     * @param frontFemale The front_female
     */
    public void setFrontFemale(Object frontFemale) {
        this.frontFemale = frontFemale;
    }

    /**
     * @return The frontShinyFemale
     */
    public Object getFrontShinyFemale() {
        return frontShinyFemale;
    }

    /**
     * @param frontShinyFemale The front_shiny_female
     */
    public void setFrontShinyFemale(Object frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    /**
     * @return The backShiny
     */
    public String getBackShiny() {
        return backShiny;
    }

    /**
     * @param backShiny The back_shiny
     */
    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    /**
     * @return The frontDefault
     */
    public String getFrontDefault() {
        return frontDefault;
    }

    /**
     * @param frontDefault The front_default
     */
    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    /**
     * @return The frontShiny
     */
    public String getFrontShiny() {
        return frontShiny;
    }

    /**
     * @param frontShiny The front_shiny
     */
    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }
}
