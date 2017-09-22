package com.example.joliver_pc.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//common mistake
import android.support.v4.app.Fragment;

//this class allows us to manipulate bottom_picture_fragment.xml file
public class BottomPictureFragment extends Fragment {

    TextView topMemeText;
    TextView bottomMemeText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //tells the compiler to  assignbottom_picture_fragment.xml XML file as this class' View reference
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        topMemeText = (TextView) view.findViewById(R.id.topMemeText);
        bottomMemeText = (TextView) view.findViewById(R.id.bottomMemeText);
        return view;
    }

    //Set the text view at the top and bottom
    public void setMemeText(String top, String bottom) {
        topMemeText.setText(top);
        bottomMemeText.setText(bottom);
    }
}
