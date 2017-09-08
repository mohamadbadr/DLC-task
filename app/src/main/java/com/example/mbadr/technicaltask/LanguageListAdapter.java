package com.example.mbadr.technicaltask;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mbadr on 9/8/2017.
 */

public class LanguageListAdapter extends ArrayAdapter<> {


    private ArrayList<HashMap<String,String>> languages;
    Context context;

    private static class ViewHolder
    {
        ImageButton iogoImage;
        Button languageButton;
    }

    public LanguageListAdapter(ArrayList<HashMap<String,String>> languages, Context context)
    {
        super(context,R.layout.language_list_item,languages);
        this.languages = languages;
        this.context = context;
    }

}
