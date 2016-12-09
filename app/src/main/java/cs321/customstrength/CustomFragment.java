package cs321.customstrength;

/**
 * Created by Savindi on 11/28/2016.
 */

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
import java.util.ArrayList;
import java.util.List;

import static cs321.customstrength.LoadExerciseData.loadCustomData;

public class CustomFragment extends Fragment {
    private View view;
    private String title;//String for tab title
    private static RecyclerView recyclerView;

    public CustomFragment() {
    }

    public CustomFragment(String title) {
        this.title = title;//Setting tab title
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

        ArrayList<String> customList = LoadExerciseData.displayExercises(loadCustomData());

        RecyclerView_Adapter adapter = new RecyclerView_Adapter(getActivity(), customList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
    }
}