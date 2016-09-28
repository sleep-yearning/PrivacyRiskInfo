package com.bp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ich on 25.06.2016.
 */
public class SettingValueFragment extends Fragment {
    String settingName; //the permission described by the fragment
    String settingValue;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment_setting_value,container,false);

        //entering the permissionName into the headline
        TextView settingNameTextView = (TextView) view.findViewById(R.id.text_setting_name);
        settingNameTextView.setText(settingName);
        TextView settingValueTextView = (TextView) view.findViewById(R.id.text_setting_value);
        settingValueTextView.setText(settingValue);

        //links the onClickEvent for returning to PermissionListFragment to the headline
        RelativeLayout button = (RelativeLayout) view.findViewById(R.id.setting_headline_frame);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {getActivity().onBackPressed();}
        });
        RelativeLayout button2 = (RelativeLayout) view.findViewById(R.id.setting_value_frame);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {getActivity().onBackPressed();}
        });

        return view;
    }

    @Override
    /**
     * Enables to pass arguments to the fragment
     * @author Tim
     */
    public void setArguments(Bundle arg){

        settingName=arg.getString("settingName");
        settingValue=arg.getString("settingValue");
    }


}
