package cs321.customstrength;

/**
 * Created by Savindi on 11/28/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static cs321.customstrength.LoadExerciseData.loadPreloadedData;

public class PreloadedFragment extends Fragment {

    private View view;
    private static String fragTitleArgText = "FRAGMENT_TITLE";

    private String title;//String for tab title
    private static RecyclerView recyclerView;

    public PreloadedFragment() {
        /*
        Bundle fragInfo = new Bundle();
        fragInfo.putString(fragTitleArgText, title);
        setArguments(fragInfo);
        */
    }

    public PreloadedFragment(String title) {
        this.title = title;//Setting tab title
    }


    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment, container, false);
        setRecyclerView();
        return view;
    }

    //Setting recycler view
    private void setRecyclerView() {
        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        ArrayList<String> preloadedList = LoadExerciseData.displayExercises(loadPreloadedData());

        recyclerView.setAdapter(new ContentAdapter(preloadedList, new ContentAdapter.OnItemClickListener() {
           @Override public void onItemClick(String item) {
                Toast.makeText(getContext(), "Exercise Clicked", Toast.LENGTH_LONG).show();
             //   Intent activityChangeIntent = new Intent
              // AllExercises.start(item);
                // currentContext.startActivity(activityChangeIntent);
               //Intent intent = new Intent(context, ExerciseInfo.class);
               //context.startActivity(intent);
               // AllExercises.start_Activity(item);
            }
        }));

        /*RecyclerView_Adapter adapter = new RecyclerView_Adapter(getActivity(), preloadedList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview*/
    }
}