package service;

import Model.Guest;
import util.TestDataReader;

public class GuestCreator {
    public static final String TESTDATA_GUEST_DIRECTION = "testadata.guest.direction";
    public static final String TESTDATA_GUEST_TRIPTYPE = "testadata.guest.triptype";
    public static final String TESTDATA_GUEST_CURENNCY = "testdata.guest.currency";
    public static final String TESTDATA_HOTEL_NAME = "testdata.guest.currency";

    public static Guest GuestWithTripDirectionAndTriptype(){
        return new Guest(TestDataReader.getTestData(TESTDATA_GUEST_DIRECTION),TestDataReader.getTestData(TESTDATA_GUEST_TRIPTYPE), "");}

    public static Guest GuestWithTripDirectionAndCurrency(){
        return new Guest(TestDataReader.getTestData(TESTDATA_GUEST_DIRECTION),
                "",
                TestDataReader.getTestData(TESTDATA_GUEST_CURENNCY));

    }
    public static Guest GuestWithTripDirectionAndHotel(){
        return new Guest(TestDataReader.getTestData(TESTDATA_HOTEL_NAME),"", "");}
}
