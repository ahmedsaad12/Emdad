package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;


public class Fragment_Terms_Condition extends Fragment {
    private Home_Activity activity;
    private Preferences preferences;
    private String current_language;
    private ImageView back;

    public static Fragment_Terms_Condition newInstance() {
        return new Fragment_Terms_Condition();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_terms_condition, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        preferences = Preferences.getInstance();
        activity = (Home_Activity) getActivity();
        current_language = preferences.getlang(activity);
        back = view.findViewById(R.id.back);
        if (current_language.equals("en")) {
            back.setRotation(180);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
    }

}