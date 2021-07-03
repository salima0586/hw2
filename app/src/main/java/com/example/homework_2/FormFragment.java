package com.example.homework_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class FormFragment extends Fragment {


    public FormFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        return view;
    }

    @Override
   public void onViewCreated(View view,Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    }
}