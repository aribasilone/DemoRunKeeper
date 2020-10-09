package com.example.runkeeperdemo.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.runkeeperdemo.R;
import com.example.runkeeperdemo.RunnerData;
import com.example.runkeeperdemo.TrophyData;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

//    @StringRes
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    //generating data for sake of testing load of personal records/awards
    private RunnerData rd;
    private String[] namesOfRecords = {"Longest Run","Highest Elevation","Fastest 5K","10K","Half Marathon","Virtual 5K Race"};
    private String[] namesOfRecords2 = {"Slowest Run","Lowest Elevation","Tough Mudder 5K","Charity 10K","Cross Country Sprint","Abstract 5K Race"};
    private String[] valuesOfRecords1 = {"00:00","2095 ft","00:00", "00:00:00","00:00","23:07"};
    private String[] valuesOfRecords2 = {"01:00","2 ft", "45:45", "12:34:56","59:59","00:05"};

    private void fillRunnerData(){
        rd = new RunnerData();
        int i=0;
        for(String s: namesOfRecords){
            TrophyData td = new TrophyData(s,valuesOfRecords1[i],true);
            rd.addTrophyData(td);
            i++;
        }
        i=0;
        for(String s: namesOfRecords2){
            TrophyData td = new TrophyData(s,valuesOfRecords2[i],true);
            rd.addTrophyData(td);
            i++;
        }

        TrophyData td = new TrophyData("Something Not Achieved","Not Yet", false);
        rd.addTrophyData(td);

    }

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        fillRunnerData();

    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);
        switch(position){
            case 0:
                return FragmentPage1.newInstance(position + 1, rd);
            case 1:
                return FragmentPage2.newInstance(position+1, rd);

            case 2:
                return FragmentPage1.newInstance(position+1, rd);

            case 3:
                return PlaceholderFragment.newInstance(position+1);

            case 4:
                return FragmentPage1.newInstance(position+1, rd);

            case 5:
                return PlaceholderFragment.newInstance(position+1);

            default:
                return PlaceholderFragment.newInstance(position+1);

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
//        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 6;
    }
}