package com.example.crapp.ui.viewAddedClass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.crapp.R;

public class viewAddedClass extends Fragment {

    private viewAddedClassModel viewAddedClassModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewAddedClassModel =
                ViewModelProviders.of(this).get(viewAddedClassModel.class);
        View root = inflater.inflate(R.layout.fragment_view_added_class, container, false);
        return root;
    }
}