package br.com.fiap.pizzaria.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido implements Parcelable {
    private String cliente;
    private List<String> sabores;
    private String tamanho;
    private String formaPegamento;
    private List<String> extras;

    public Pedido(String cliente) {
        this.cliente = cliente;
        sabores = new ArrayList<>();
        extras = new ArrayList<>();
    }

    protected Pedido(Parcel in) {
        cliente = in.readString();
        sabores = in.createStringArrayList();
        tamanho = in.readString();
        formaPegamento = in.readString();
        extras = in.createStringArrayList();
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public void addSabor(String sabor) {
        this.sabores.add(sabor);
    }

    public void removeSabor(String sabor) {
        this.sabores.remove(sabor);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormaPegamento() {
        return formaPegamento;
    }

    public void setFormaPegamento(String formaPegamento) {
        this.formaPegamento = formaPegamento;
    }

    public List<String> getExtras() {
        return extras;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }

    public void addExtra(String extra) {
        this.extras.add(extra);
    }

    public void removeExtra(String extra) {
        this.extras.remove(extra);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cliente);
        dest.writeStringList(sabores);
        dest.writeString(tamanho);
        dest.writeString(formaPegamento);
        dest.writeStringList(extras);
    }
}
