package cs321.customstrength;

/**
 * Created by Savindi on 11/28/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AllExercises extends AppCompatActivity {
    private static Toolbar toolbar;
    private static ViewPager viewPager;
    private static TabLayout tabLayout;

    private static Button addCustomButton;
    //public static  tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);//setting tab over viewpager
        addListenerOnButton();
        
        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//setting current selected item over viewpager
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","TAB1");
                        break;
                    case 1:
                        Log.e("TAG","TAB2");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    
    public void addListenerOnButton(){
    addCustomButton = new Button(this);
    addCustomButton.setText("+");
    addCustomButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view){
        addCustom(view);
      }
    } );
  }
    //Setting View Pager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.clearFrag();
        adapter.addFrag(new PreloadedFragment("Preloaded Exercises"), "Preloaded Exercises");
        adapter.addFrag(new CustomFragment("Custom Exercises"), "Custom Exercises");

        viewPager.setAdapter(adapter);
    }
    public void addCustom(View view){
        Intent createIntent=new Intent(this, addCustomExercise.class);
        startActivity(createIntent);
    }
    public void removeCustom(View view){
    }
    //View Pager fragments setting adapter class
    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private static final List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
        private static final List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        //adding fragments and title method
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @SuppressWarnings("remove")
        public void clearFrag(){
            mFragmentList.removeAll(mFragmentList);
            mFragmentTitleList.removeAll(mFragmentTitleList);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
          // onClick for adding a custom exercise

    }
}