package com.freakybyte.poketest.controller.home.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freakybyte.poketest.R;
import com.freakybyte.poketest.controller.listener.RecyclerListListener;
import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.ui.wrapper.ItemPokeWrapper;
import com.freakybyte.poketest.util.PokeTestUtil;

import java.util.ArrayList;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class PokeListAdapter extends RecyclerView.Adapter<ItemPokeWrapper> {

    public static final String TAG = "PokeListAdapter";
    private ArrayList<PokeModel> aListPokemon = new ArrayList<>();
    private Activity mActivity;
    private RecyclerListListener mClickListener;

    /**
     * @param context
     */
    public PokeListAdapter(Activity context, RecyclerListListener mClickListener) {
        this.mActivity = context;
        this.mClickListener = mClickListener;
    }

    @Override
    public ItemPokeWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pokemon, parent, false);
        ItemPokeWrapper vh = new ItemPokeWrapper(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ItemPokeWrapper viewHolder, final int position) {
        final PokeModel mPokemon = aListPokemon.get(position);

        viewHolder.getTxName().setText(mPokemon.getName());
        viewHolder.getImgRowIcon().setImageURI(PokeTestUtil.getUrlStringToFullPokemon(mPokemon.getId()));

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null)
                    mClickListener.OnItemClickListener(viewHolder.getImgRowIcon(), position);
            }
        });
        viewHolder.getTxName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null)
                    mClickListener.OnItemClickListener(viewHolder.getImgRowIcon(), position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return aListPokemon.size();
    }

    public ArrayList<PokeModel> getListPokemon() {
        return aListPokemon;
    }

    public void setListPokemon(ArrayList<PokeModel> aListFood) {
        this.aListPokemon = aListFood;
    }
}
