package com.historichologram.tucsontourguide;

import java.util.ArrayList;

/**
 * Created by chrismacholtz on 10/2/16.
 */

public class LocationItem extends ArrayList {
    private int mLocationNameId;
    private int mLocationShortId;
    private int mLocationCallId = NO_INFO_PROVIDED;
    private int mLocationDirectionsId = NO_INFO_PROVIDED;
    private int mLocationWebsiteId = NO_INFO_PROVIDED;
    private int mLocationLongId;
    private int mLocationTipId;
    private int mLocationImageId = NO_INFO_PROVIDED;
    final static int NO_INFO_PROVIDED = -1;


    //Constructor with all the fixin's
    public LocationItem(int locationNameId, int locationShortId, int locationLongId, int locationTipId, int locationCallId,
                        int locationDirectionsId, int locationWebsiteId,int locationImageId) {
        mLocationNameId = locationNameId;
        mLocationShortId = locationShortId;
        mLocationLongId = locationLongId;
        mLocationTipId = locationTipId;
        mLocationCallId = locationCallId;
        mLocationDirectionsId = locationDirectionsId;
        mLocationWebsiteId = locationWebsiteId;
        mLocationImageId = locationImageId;
    }

    //Constructor without the buttons
    public LocationItem(int locationNameId, int locationShortId, int locationLongId, int locationTipId, int locationImageId) {
        mLocationNameId = locationNameId;
        mLocationShortId = locationShortId;
        mLocationLongId = locationLongId;
        mLocationTipId = locationTipId;
        mLocationImageId = locationImageId;
    }

    //Constructor without the image or the buttons
    public LocationItem(int locationNameId, int locationShortDescriptionId,  int locationLongId, int locationTipId) {
        mLocationNameId = locationNameId;
        mLocationShortId = locationShortDescriptionId;
        mLocationLongId = locationLongId;
        mLocationTipId = locationTipId;
    }

    public int getLocationNameId() { return mLocationNameId; }

    public int getLocationShortDescriptionId() { return mLocationShortId; }

    public int getLocationCallId() { return mLocationCallId; }

    public int getLocationDirectionsId() { return mLocationDirectionsId; }

    public int getLocationWebsiteId() { return mLocationWebsiteId; }

    public int getLocationLongId() { return mLocationLongId; }

    public int getLocationTipId() { return mLocationTipId; }

    public int getLocationImageId() { return mLocationImageId; }

    public boolean hasImage() { return mLocationImageId != NO_INFO_PROVIDED; }

    public boolean hasButtons() { return mLocationCallId != NO_INFO_PROVIDED || mLocationDirectionsId != NO_INFO_PROVIDED
            || mLocationWebsiteId != NO_INFO_PROVIDED; }
}
