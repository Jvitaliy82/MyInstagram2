package ru.jdeveloperapps.myinstagram2;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class DataSourceBuilder {

    private List<CustModelCard> dataSource;
    private Resources resources;

    public DataSourceBuilder(Resources resources) {
        this.dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public List<CustModelCard> build(int n) {
        dataSource = new ArrayList<>();
        switch (n) {
            case 1:
                buildFrut();
                break;
            case 2:
                buildVegetables();
                break;
            case 3:
                buildNature();
                break;
        }
        return dataSource;
    }

    private void buildFrut() {
        TypedArray frutPictures = resources.obtainTypedArray(R.array.fruts_picture);
        int lenght = frutPictures.length();
        int[] fruts = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            fruts[i] = frutPictures.getResourceId(i, 0);
        }

        String[] tit = resources.getStringArray(R.array.fruts_title);

        String[] desc = resources.getStringArray(R.array.fruts_desc);

        for (int i = 0; i < fruts.length; i++) {
            CustModelCard custModelCard = new CustModelCard(
                    tit[i], desc[i], fruts[i]
            );
            dataSource.add(custModelCard);
        }
    }

    private void buildVegetables() {
        TypedArray vegetablePictures = resources.obtainTypedArray(R.array.vegetable_picture);
        int lenght = vegetablePictures.length();
        int[] fruts = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            fruts[i] = vegetablePictures.getResourceId(i, 0);
        }

        String[] tit = resources.getStringArray(R.array.vegetable_title);

        String[] desc = resources.getStringArray(R.array.vegetable_desc);

        for (int i = 0; i < fruts.length; i++) {
            CustModelCard custModelCard = new CustModelCard(
                    tit[i], desc[i], fruts[i]
            );
            dataSource.add(custModelCard);
        }
    }

    private void buildNature() {
        TypedArray naturePictures = resources.obtainTypedArray(R.array.nature_picture);
        int lenght = naturePictures.length();
        int[] fruts = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            fruts[i] = naturePictures.getResourceId(i, 0);
        }

        String[] tit = resources.getStringArray(R.array.nature_title);

        String[] desc = resources.getStringArray(R.array.nature_desc);

        for (int i = 0; i < fruts.length; i++) {
            CustModelCard custModelCard = new CustModelCard(
                    tit[i], desc[i], fruts[i]
            );
            dataSource.add(custModelCard);
        }
    }
}
