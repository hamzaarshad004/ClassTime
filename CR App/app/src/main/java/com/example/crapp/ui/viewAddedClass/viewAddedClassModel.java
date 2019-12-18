package com.example.crapp.ui.viewAddedClass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewAddedClassModel extends ViewModel {

    private MutableLiveData<String> mText;

    public viewAddedClassModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}