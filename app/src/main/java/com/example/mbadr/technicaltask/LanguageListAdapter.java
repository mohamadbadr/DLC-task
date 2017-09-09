package com.example.mbadr.technicaltask;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.contextClickable;
import static android.R.attr.id;
import static android.R.attr.packageNames;
import static android.R.attr.targetActivity;
import static android.R.attr.targetPackage;

/**
 * Created by mbadr on 9/8/2017.
 */

public class LanguageListAdapter extends ArrayAdapter<HashMap<String, String>> {


    private ArrayList<HashMap<String,String>> languages;
    Context context;

    private static class ViewHolder
    {
        ImageView logoImage;
        Button languageButton;
    }

    public LanguageListAdapter(ArrayList<HashMap<String,String>> languages, Context context)
    {
        super(context,R.layout.language_list_item,languages);
        this.languages = languages;
        this.context = context;
    }

//    public static Drawable stringToDrawable(String name)
//    {
//        int id = Resources.getSystem().getIdentifier(name,"drawable", String.valueOf(packageNames));
//
//    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HashMap<String,String> language = getItem(position);
        String abbrev = language.get("abbrev");

        int id = this.context.getResources().getIdentifier(abbrev,"drawable",this.context.getPackageName());
//        Log.e("Image ID",id + "");
        Drawable d = this.context.getResources().getDrawable(id);

        ViewHolder viewHolder;

        final View result;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.language_list_item,parent,false);
            viewHolder.logoImage = (ImageView) convertView.findViewById(R.id.language_Image_button);
            viewHolder.languageButton = (Button) convertView.findViewById(R.id.language_button);
            result = convertView;
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Typeface relway_regular = Typeface.createFromAsset(this.context.getAssets(), "fonts/Raleway-Regular.ttf");

        if(language.get("abbrev").equals("eng"))
            viewHolder.languageButton.setText(language.get("title") + " US");
        else if(language.get("abbrev").equals("euk"))
            viewHolder.languageButton.setText(language.get("title") + " UK");
        else
            viewHolder.languageButton.setText(language.get("title"));

        viewHolder.languageButton.setTypeface(relway_regular);
        viewHolder.logoImage.setImageResource(id);

        return convertView;
    }
}
