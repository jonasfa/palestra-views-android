package com.github.jonasfa.qconandroid.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    static final Class[] activities = new Class[]{PlayStore.class, Qoiza.class};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ActivitiesAdapter());
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, (Class) getListAdapter().getItem(position)));
    }

    private class ActivitiesAdapter extends ArrayAdapter<Class> {
        public ActivitiesAdapter() {
            super(MainActivity.this, android.R.layout.simple_list_item_1, activities);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setText(getItem(position).getSimpleName());
            return view;
        }
    }
}
