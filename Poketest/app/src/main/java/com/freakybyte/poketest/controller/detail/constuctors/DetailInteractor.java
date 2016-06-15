package com.freakybyte.poketest.controller.detail.constuctors;

import com.freakybyte.poketest.controller.detail.listener.OnRequestDetailListener;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public interface DetailInteractor {

    void getPokemonDetailFromServer(OnRequestDetailListener mListener, long id);
}
