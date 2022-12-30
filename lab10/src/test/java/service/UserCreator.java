package service;

import Model.Guest;
import Model.User;
import util.TestDataReader;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.fistname";
    public static final String TESTDATA_USER_SECNAME = "testdata.user.secondname";
    public static final String TESTDATA_USER_PHONE = "testdata.user.phone";

    public static final String TESTDATA_USER_HOTEL = "testdata.hotel.name";
    public static final String TESTDATA_USER_EMAIL = "testdata.hotel.email";
    public static User UserCreateDef()
    {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),TestDataReader.getTestData(TESTDATA_USER_SECNAME),
                TestDataReader.getTestData(TESTDATA_USER_PHONE),TestDataReader.getTestData(TESTDATA_USER_HOTEL),TestDataReader.getTestData(TESTDATA_USER_EMAIL));}


}
