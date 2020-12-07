package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import  com.example.prueba.data.*;
import com.example.prueba.models.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<actividadesModel> mModelList;
    private actividadesAssetSource assets;

    private static final String TAG = MainActivity.class.getName();

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private  void setup(){
        assets = new actividadesAssetSource(getBaseContext());
        mModelList = new ArrayList<>();
    }

    @Override

    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        if(!mModelList.isEmpty()) {
            Log.d(TAG, "Ya existen valores en la lista");
            return;
        }
        mModelList = assets.getAll();
        loadRecycleFragment(new ArrayList<actividadesModel>(mModelList));
    }

    private void loadRecycleFragment(ArrayList<actividadesModel> points) {
        FragmentTransaction frgTran = getSupportFragmentManager().beginTransaction();
        frgTran.replace(R.id.fundations_ph, fundationFragment.newInstance(points));
        frgTran.commit();
    }

}