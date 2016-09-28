package com.bp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ich on 25.06.2016.
 */
public class BigTrophyViewFragment extends Fragment {
    String trophyName; //the name of the described trophy

    /**
     * @author Tim
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**setts the name and image of the trophy view
     * @autor Tim
     * @param inflater
     * @param container
     * @param saveInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_big_trophy_view,container,false);
        TextView trophyName= (TextView) view.findViewById(R.id.text_trophy_name);
        trophyName.setText(this.trophyName);
        return view;
    }

    @Override
    /**
     * Enables to pass arguments to the fragment
     * @author Tim
     */
    public void setArguments(Bundle arg){
        trophyName=arg.getString("trophyName");
    }

}
