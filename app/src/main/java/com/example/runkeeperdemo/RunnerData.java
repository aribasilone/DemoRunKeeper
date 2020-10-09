package com.example.runkeeperdemo;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class RunnerData implements Parcelable {
   private HashMap<String, TrophyData> hashData;

   public RunnerData(){
       hashData = new HashMap<>();
   }

   public void addTrophyData(TrophyData td){

       if(!hashData.containsKey(td.getName())){
           hashData.put(td.getName(),td);
       }

   }


   public TrophyData getRunnerData(CharSequence requestedTrophyName){
       if(hashData.containsKey(requestedTrophyName)){
           return hashData.get(requestedTrophyName);
       }
       else{
           return null;
       }
   }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
