package com.example.joliver_pc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class TopSectionFragment extends Fragment {

    EditText topTextInput;
    EditText bottomTextInput;
    Button button ;

    TopSectionListener activityCommander;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //tells the compiler to use this XML file
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        //Get the text and button's id
        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        button = (Button) view.findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        try {
            activityCommander = (TopSectionListener) context;
        } catch(ClassCastException ex) {
            throw new ClassCastException();
        }
        super.onAttach(context);
    }

    //pass the TextView value into TopSectionListener's createMeme() method.
    public void clickButton(View v) {
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
