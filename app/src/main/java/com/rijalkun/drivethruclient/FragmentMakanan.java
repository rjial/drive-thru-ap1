package com.rijalkun.drivethruclient;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.rijalkun.drivethruclient.model.MakananModel;
import com.rijalkun.drivethruclient.model.MenuModel;
import com.rijalkun.drivethruclient.viewmodel.MenuViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMakanan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMakanan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMakanan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMakanan.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMakanan newInstance(String param1, String param2) {
        FragmentMakanan fragment = new FragmentMakanan();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("WrongThread")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_makanan, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_Makanan);
        MenuViewModel menuViewModel = new MenuViewModel(getActivity().getApplication());
        menuViewModel.getMakananList().observe(getViewLifecycleOwner(), new Observer<List<MenuModel>>() {
            @Override
            public void onChanged(List<MenuModel> makananModels) {
                List<MenuModel> list = makananModels;
                MakananAdapter menuAdapter = new MakananAdapter(list);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                recyclerView.setAdapter(menuAdapter);
            }
        });
//        ConnectMysql connectMysql = new ConnectMysql();
//        try {
//            List<MakananModel> list = connectMysql.getMakanan();
//            MenuAdapter menuAdapter = new MenuAdapter(list);
//            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//            recyclerView.setAdapter(menuAdapter);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (java.lang.InstantiationException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return view;
    }

}