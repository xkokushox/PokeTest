package com.freakybyte.poketest.model.summary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class PokemonDetailModel {


    @SerializedName("forms")
    @Expose
    private List<FormModel> forms = new ArrayList<>();
    @SerializedName("abilities")
    @Expose
    private List<AbilityModel> abilities = new ArrayList<>();
    @SerializedName("stats")
    @Expose
    private List<StatModel> stats = new ArrayList<>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("moves")
    @Expose
    private List<MoveModel> moves = new ArrayList<>();
    @SerializedName("sprites")
    @Expose
    private SpritesModel sprites;
    @SerializedName("held_items")
    @Expose
    private List<Object> heldItems = new ArrayList<>();
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("species")
    @Expose
    private SpeciesModel species;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndexModel> gameIndices = new ArrayList<>();
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("types")
    @Expose
    private List<TypeModel> types = new ArrayList<>();

    /**
     * @return The forms
     */
    public List<FormModel> getForms() {
        return forms;
    }

    /**
     * @param forms The forms
     */
    public void setForms(List<FormModel> forms) {
        this.forms = forms;
    }

    /**
     * @return The abilities
     */
    public List<AbilityModel> getAbilities() {
        return abilities;
    }

    /**
     * @param abilities The abilities
     */
    public void setAbilities(List<AbilityModel> abilities) {
        this.abilities = abilities;
    }

    /**
     * @return The stats
     */
    public List<StatModel> getStats() {
        return stats;
    }

    /**
     * @param stats The stats
     */
    public void setStats(List<StatModel> stats) {
        this.stats = stats;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return The moves
     */
    public List<MoveModel> getMoves() {
        return moves;
    }

    /**
     * @param moves The moves
     */
    public void setMoves(List<MoveModel> moves) {
        this.moves = moves;
    }

    /**
     * @return The sprites
     */
    public SpritesModel getSprites() {
        return sprites;
    }

    /**
     * @param sprites The sprites
     */
    public void setSprites(SpritesModel sprites) {
        this.sprites = sprites;
    }

    /**
     * @return The heldItems
     */
    public List<Object> getHeldItems() {
        return heldItems;
    }

    /**
     * @param heldItems The held_items
     */
    public void setHeldItems(List<Object> heldItems) {
        this.heldItems = heldItems;
    }

    /**
     * @return The locationAreaEncounters
     */
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    /**
     * @param locationAreaEncounters The location_area_encounters
     */
    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    /**
     * @return The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return The isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault The is_default
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return The species
     */
    public SpeciesModel getSpecies() {
        return species;
    }

    /**
     * @param species The species
     */
    public void setSpecies(SpeciesModel species) {
        this.species = species;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return The gameIndices
     */
    public List<GameIndexModel> getGameIndices() {
        return gameIndices;
    }

    /**
     * @param gameIndices The game_indices
     */
    public void setGameIndices(List<GameIndexModel> gameIndices) {
        this.gameIndices = gameIndices;
    }

    /**
     * @return The baseExperience
     */
    public Integer getBaseExperience() {
        return baseExperience;
    }

    /**
     * @param baseExperience The base_experience
     */
    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    /**
     * @return The types
     */
    public List<TypeModel> getTypes() {
        return types;
    }

    /**
     * @param types The types
     */
    public void setTypes(List<TypeModel> types) {
        this.types = types;
    }

}
