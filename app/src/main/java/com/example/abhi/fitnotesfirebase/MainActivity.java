package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.abhi.workoutapp.R;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FloatingActionButton fab2;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, fab2);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You clicked: " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        if (item.getTitle().equals("Your Weight")){
                            Intent intent = new Intent(MainActivity.this, EnterWeight.class);
                            intent.putExtra("userWeight", "userWeight");
                            startActivity(intent);
                        }
                        else if (item.getTitle().equals("Bench")){
                            Intent intent = new Intent(MainActivity.this, EnterWeight.class);
                            intent.putExtra("benchWeight", "benchWeight");
                            startActivity(intent);
                        }
                        else if (item.getTitle().equals("Squat")){
                            Intent intent = new Intent(MainActivity.this, EnterWeight.class);
                            intent.putExtra("squatWeight", "squatWeight");
                            startActivity(intent);
                        }
                        else if (item.getTitle().equals("Deadlift")){
                            Intent intent = new Intent(MainActivity.this, EnterWeight.class);
                            intent.putExtra("deadliftWeight", "deadliftWeight");
                            startActivity(intent);
                        }
                        else if (item.getTitle().equals("Ohp")){
                            Intent intent = new Intent(MainActivity.this, EnterWeight.class);
                            intent.putExtra("ohpWeight", "ohpWeight");
                            startActivity(intent);
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Day1Tab tab1 = new Day1Tab();
                    return tab1;
                case 1:
                    Day2Tab tab2 = new Day2Tab();
                    return tab2;
                case 2:
                    Day3Tab tab3 = new Day3Tab();
                    return tab3;
                case 3:
                    Day4Tab tab4 = new Day4Tab();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "DAY 1";
                case 1:
                    return "DAY 2";
                case 2:
                    return "DAY 3";
                case 3:
                    return "DAY 4";
            }
            return null;
        }
    }
}
