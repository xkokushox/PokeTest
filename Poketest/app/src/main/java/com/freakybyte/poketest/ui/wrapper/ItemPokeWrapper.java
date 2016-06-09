package com.freakybyte.poketest.ui.wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.ui.textview.CapitalizedTextView;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class ItemPokeWrapper extends RecyclerView.ViewHolder {

    public View view = null;

    private CapitalizedTextView txtRowTitle = null;
    private SimpleDraweeView imgRowIcon = null;


    public ItemPokeWrapper(View base) {
        super(base);
        this.view = base;
    }

    public CapitalizedTextView getTxName() {
        if (txtRowTitle == null)
            txtRowTitle = (CapitalizedTextView) view.findViewById(R.id.txtRowTitle);
        return txtRowTitle;
    }

    public SimpleDraweeView getImgRowIcon() {
        if (imgRowIcon == null)
            imgRowIcon = (SimpleDraweeView) view.findViewById(R.id.imgRowIcon);
        return imgRowIcon;
    }

}
