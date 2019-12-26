package com.example.crapp.ui.LogOut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.crapp.MainActivity;
import com.example.crapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogOut extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();

        startActivity(new Intent(getContext(), MainActivity.class));
        getActivity().finish();
    }
}