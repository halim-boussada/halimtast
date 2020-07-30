package com.example.lasttry.Model;

import java.util.List;

public class ListTrip {
    List<Trip> mTripList;
    int IndexOfmTripList;

    public ListTrip(List<Trip> tripList) {
        mTripList = tripList;
        IndexOfmTripList=0;
    }
    public Trip GetNextTrip()
    {
        if(IndexOfmTripList==mTripList.size()){IndexOfmTripList=0;}
        return mTripList.get(IndexOfmTripList++);
    }
    public Trip GetPreviousTrip()
    {
        if(IndexOfmTripList==-1){IndexOfmTripList=2;}
        return mTripList.get(IndexOfmTripList--);
    }
}
