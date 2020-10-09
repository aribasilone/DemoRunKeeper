package com.example.runkeeperdemo.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.runkeeperdemo.R;
import com.example.runkeeperdemo.RunnerData;
import com.example.runkeeperdemo.TrophyData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPage1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPage1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PAGE_NUMBER = "page_number";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
    private RunnerData mParam2;

    private PageViewModel pageViewModel;

    public FragmentPage1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param index
     * @return A new instance of fragment FragmentPage1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPage1 newInstance(int index, RunnerData runnerData) {
        FragmentPage1 fragment = new FragmentPage1();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, index);
        args.putParcelable(ARG_PARAM2, runnerData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getParcelable(ARG_PARAM2);
        }

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PAGE_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_page1, container, false);
        final TextView textView = root.findViewById(R.id.personalRecords_pagination);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //declare all the textviews to cross reference with, then all the text to change with the person's time
        final TextView badge1 = root.findViewById(R.id.name_badge1);
        final TextView badge1_v = root.findViewById(R.id.value_badge1);

        final TextView badge2 = root.findViewById(R.id.name_badge2);
        final TextView badge2_v = root.findViewById(R.id.value_badge2);

        final TextView badge3 = root.findViewById(R.id.name_badge3);
        final TextView badge3_v = root.findViewById(R.id.value_badge3);

        final TextView badge4 = root.findViewById(R.id.name_badge4);
        final TextView badge4_v = root.findViewById(R.id.value_badge4);

        final TextView badge5 = root.findViewById(R.id.name_badge5);
        final TextView badge5_v = root.findViewById(R.id.value_badge5);

        final TextView badge6 = root.findViewById(R.id.name_badge6);
        final TextView badge6_v = root.findViewById(R.id.value_badge6);

        //check that there is a match between the intended textview, and what is stored
        //if the textview has same name as a record in the runner data, then update the value
       if(mParam2.getRunnerData(badge1.getText()) != null){
           badge1_v.setText(mParam2.getRunnerData(badge1.getText()).getValue());
       }

        if(mParam2.getRunnerData(badge2.getText()) != null){
            badge2_v.setText(mParam2.getRunnerData(badge2.getText()).getValue());
        }

        if(mParam2.getRunnerData(badge3.getText()) != null){
            badge3_v.setText(mParam2.getRunnerData(badge3.getText()).getValue());
        }

        if(mParam2.getRunnerData(badge4.getText()) != null){
            badge4_v.setText(mParam2.getRunnerData(badge4.getText()).getValue());
        }

        if(mParam2.getRunnerData(badge5.getText()) != null){
            badge5_v.setText(mParam2.getRunnerData(badge5.getText()).getValue());
        }

        if(mParam2.getRunnerData(badge6.getText()) != null){
            badge6_v.setText(mParam2.getRunnerData(badge6.getText()).getValue());
        }


        return root;
    }
}