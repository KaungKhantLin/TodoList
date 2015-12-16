package com.kaungkhantlynn.testingtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

import model.Todo;

/**
 * Created by kaungkhantlynn on 12/11/15.
 */
public class OneFragment extends android.support.v4.app.Fragment  {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    ListView lv;
    public OneFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public static List<Todo> getAll()
    {
        return new Select()
                .from(Todo.class)
                .execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List<Todo> todos=getAll();


         View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        lv=(ListView)getActivity().findViewById(R.id.mlistview);

        return rootView;

    }

    public void showAll(View view)
    {
        Select select=new Select();
        List<Todo> todo = select.all().from(Todo.class).execute();

        StringBuilder builder = new StringBuilder();
        for (Todo data : todo) {
            builder.append("Articles: ")
                    .append(data.articles)
                    .append(" Age: ")
                    .append(data.day)
                    .append("Month :")
                    .append(data.month)
                    .append("Year :")
                    .append(data.year)
                    .append("\n");
        }
        Toast.makeText(getActivity(), builder.toString(), Toast.LENGTH_LONG).show();


    }

}
