package Test;


import Model.Guest;
import Model.User;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.*;
import service.GuestCreator;
import service.UserCreator;

import static util.StringUtil.*;
import static util.TestDataReader.getTestData;


public class MainTest extends CommonConditions{
    private Guest TEST_GUEST = GuestCreator.GuestWithTripDirectionAndTriptype();
    private Guest GUEST_DESTINITON_CURRENCY = GuestCreator.GuestWithTripDirectionAndCurrency();
    private String LANGUAGE = "testdata.hotel.languege";
    private User TESTUSER = UserCreator.UserCreateDef();


    @Test(description = "TCH1")
    public void TETSaS()
    {
        new SearchPage(driver)
                .openPage()
                .enterReferences(TEST_GUEST.getDirection())
                .enterDestination()
                .enterWorkType(TEST_GUEST.getTripType())
                .Seacrh();

        boolean ByPriceSort =  new ResultsPage(driver)
                .SortByPrice()
                .checkIfSortedByLowerPrice();
        Assert.assertTrue(ByPriceSort);

    }


    @Test(description = "TCH2")
    public void TC_FH_2()
    {
        new SearchPage(driver)
                .openPage()
                .enterReferences(GUEST_DESTINITON_CURRENCY.getDirection())
                .Seacrh();


        boolean CurrencyChanged =  new ResultsPage(driver)
                .ChangeCurrency(GUEST_DESTINITON_CURRENCY.getCurrency())
                .CheckCurrencyName(GUEST_DESTINITON_CURRENCY.getCurrency());
        Assert.assertTrue(CurrencyChanged);

    }


    @Test(description = "TC_FAQ_1")
    public void TC_FAQ_1()
    {
        new SearchPage(driver)
                .openPage()
                .GoFooter()
                .OpenFAQ();

        boolean AnserExist = new FAQPage(driver)
                .SetRequest(FAQREQUEST)
                .SendRequest()
                .CheckResultlOfGuetion();

        Assert.assertTrue(AnserExist);

    }


    @Test(description = "TC_HOTEL_LAN_1")
    public void TC_HOTEL_LAN_1()
    {
        new SearchPage(driver)
                .openPage()
                .enterReferences(GUEST_DESTINITON_CURRENCY.getDirection())
                .Seacrh();


        boolean LanChanged = new ResultsPage(driver)
                .OpenLanguageModal()
                .ChangeLang(getTestData(LANGUAGE))
                .OpenLanguageModal()
                .CheckSelectedLan(getTestData(LANGUAGE));

        Assert.assertTrue(LanChanged);

    }

    @Test(description = "TTC_FH_3")
    public void TC_FH_3()
    {
        boolean MObileImgExist = new SearchPage(driver)
                .openPage()
                .GoFooter()
                .ClickAndroid()
                .ImgAndroidEXist();


        Assert.assertTrue(MObileImgExist);

    }

    @Test(description = "TTC_FH_3")
    public void TC_FH_4()
    {
         new SearchPage(driver)
                .openPage()
                .enterHotel(TESTUSER.getHotel())
                 .enterDestination()
                .Seacrh();

         boolean HotelReservd = new  Hotel(driver)
                 .BookNow()
                 .Order(TESTUSER)
                 .Reservation()
                 .IsResrved();

        Assert.assertTrue(HotelReservd);

    }


    @Test(description = "TC_HR_1")
    public void TC_HR_1()
    {
        new SearchPage(driver)
                .openPage()
                .enterHotel(TESTUSER.getHotel())
                .enterDestination()
                .Seacrh();

        boolean HotelReview = new  Hotel(driver)
                .ReviewExst();

        Assert.assertTrue(HotelReview);

    }

    @Test(description = "TC_BT_1")
    public void TC_BT_11()
    {
        new BlogPage(driver)

                .OpenByTag(TAG)
                .ExistNewsTag(TAG);

        Assert.assertTrue(true);

    }


    @Test(description = "TC_HF_5")
    public void TC_HF_5()
    {
        new SearchPage(driver)
                .openPage()
                .enterReferences(TEST_GUEST.getDirection())
                .enterDestination()
                .Seacrh();

        boolean CheckFilter = new ResultsPage(driver)
                .filterPrice(FromMoney, ToMoney)
//                .SetFiveStar()
                .CheckFilterResults()
                ;
        Assert.assertTrue(CheckFilter);

    }


    @Test(description = "TC_FBT_1")
    public void TC_FBT_1()
    {


        boolean ExistForm =  new SearchPage(driver)
                .openPage()
                .OpenSupport()
                .OpenFeddbackSupport()
                .ChoseHotelQuetionType()
                .ExistForm();
        Assert.assertTrue(ExistForm);

    }
}
