package com.example.joliver_pc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

//common mistake
import android.support.v4.app.Fragment;

//this class allows us to manipulate top_section_fragment.xml file
public class TopSectionFragment extends Fragment {

    Context context;

    EditText topTextInput;
    EditText bottomTextInput;
    Button button ;

    TopSectionListener mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //tells the compiler to  assign top_section_fragment.xml XML file as this class' View reference
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        //get the context you are currently in
        context = view.getContext();

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

    //this is how you communicate with the MainActivity, get the context reference from OnAttach(context) method.
    //get an instance of the TopSectionListener object (it will be MainActivity extends AppCompatActivity(a Context) implements TopSectionListener)
    /*
    @Override
    public void onAttach(Context context) {
        try {
            mainActivity = (TopSectionListener) context;
        } catch(ClassCastException ex) {
            throw new ClassCastException();
        }
        super.onAttach(context);
    }
    */


    //pass the TextView value into TopSectionListener's createMeme() method.
    public void clickButton(View v) {
        //alternate way for onAttach() method
        mainActivity = (TopSectionListener) context;
        mainActivity.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
