package com.example.prueba.data;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.example.prueba.helpers.*;
import com.example.prueba.models.*;
public class actividadesAssetSource {

    private final Gson parser;
    private final Context mContext;
    private static final String RECYCLE_FILE_NAME = "actividades.json";
    private static final String RECYCLE_SERIALIZED_NAME = "actividades";

    public actividadesAssetSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }

    public List<actividadesModel> getAll() {
        String json = FileHelper.getJsonFromAssets(mContext, RECYCLE_FILE_NAME);
        ListResult listResult = parser.fromJson(json, ListResult.class);
        if(listResult == null) return null;
        return listResult.list;
    }

    static class ListResult {
        @SerializedName(RECYCLE_SERIALIZED_NAME)
        List<actividadesModel> list;

        public ListResult(List<actividadesModel> list) {
            this.list = list;
        }
    }


}
