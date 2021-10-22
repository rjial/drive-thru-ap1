package com.rijalkun.drivethruclient.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.rijalkun.drivethruclient.model.MakananModel;
import com.rijalkun.drivethruclient.model.MenuModel;
import com.rijalkun.drivethruclient.model.MinumanModel;
import com.rijalkun.drivethruclient.repository.MenuRepository;

import java.util.List;

public class MenuViewModel extends AndroidViewModel {
    private MenuRepository menuRepository;
    public MenuViewModel(@NonNull Application application) {
        super(application);
        menuRepository = new MenuRepository();
    }
    public MutableLiveData<List<MenuModel>> getMakananList() {
        return menuRepository.getMakananList();
    }
    public MutableLiveData<List<MenuModel>> getMinumanList() {
        return menuRepository.getMinumanList();
    }
}
