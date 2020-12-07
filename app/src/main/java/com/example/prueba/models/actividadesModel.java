package com.example.prueba.models;
import android.os.Parcel;
import android.os.Parcelable;

public class actividadesModel implements Parcelable {

    private String ImgUrl;
    private String nombre;
    private String presupuesto;
    private  String descripcion;

public actividadesModel(String imgUrl, String nombre, String presupuesto, String descripcion){

    ImgUrl = imgUrl;
    this.nombre = nombre;
    this.presupuesto = presupuesto;
    this.descripcion = descripcion;

}

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

protected actividadesModel(Parcel in)
{
    ImgUrl = in.readString();
    nombre = in.readString();
    presupuesto = in.readString();
    descripcion = in.readString();


}

    public static final Creator<actividadesModel> CREATOR = new Creator<actividadesModel>() {
        @Override
        public actividadesModel createFromParcel(Parcel in) {
            return new actividadesModel(in);
        }

        @Override
        public actividadesModel[] newArray(int size) {
            return new actividadesModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(ImgUrl);
    dest.writeString(nombre);
    dest.writeString(presupuesto);
    dest.writeString(descripcion);
    }
}
