package com.icookbook.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icookbook.R;

public class PopularRecepiesFragment extends Fragment{
	 @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
     }
	 
	 @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.popular_recepies_layout, container, false);
         View tv = v.findViewById(R.id.text);
         ((TextView)tv).setText("Popular Fragment");
         return v;
     }

}
