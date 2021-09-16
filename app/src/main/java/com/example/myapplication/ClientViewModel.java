package com.example.myapplication;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ClientViewModel extends BaseObservable{
    private Client model;
    @Bindable
    public String getName(){
        return this.model.getNom();
    }
    public void setName(String name){
        this.model.setNom(name);
        notifyPropertyChanged(BR.name);
    }
}
