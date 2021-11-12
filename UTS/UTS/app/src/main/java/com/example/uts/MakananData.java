package com.example.uts;

import java.util.ArrayList;

public class MakananData {
    private static String[] NamaMakanan = {
            "Mie Ayam",
            "Ayam Geprek",
            "Soto Ayam",
            "Nasi Goreng"

    };

    private static String[] DetailMakanan = {
            "Mie Ayam Komplit",
            "Ayam Geprek Pedas Extra",
            "Soto Ayam Enakkk",
            "Nasi Goreng SUper Pedas"
    };

    private static String[] HargaMakanan = {
            "20.000",
            "25.000",
            "12.000",
            "15.000",
    };

    private static int[] FotoMakanan = {
            R.drawable.mieayam,
            R.drawable.ayamgeprek,
            R.drawable.sotoayam,
            R.drawable.nasigoreng,
    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position <NamaMakanan.length; position++){
            Makanan makanan = new Makanan();
            makanan.setNama(NamaMakanan[position]);
            makanan.setDetail(DetailMakanan[position]);
            makanan.setHarga(HargaMakanan[position]);
            makanan.setPhoto(FotoMakanan[position]);
            list.add(makanan);
        }
        return list;
    }
}
