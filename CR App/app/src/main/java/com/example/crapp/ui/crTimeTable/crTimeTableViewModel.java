package com.example.crapp.ui.crTimeTable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class crTimeTableViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public crTimeTableViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}