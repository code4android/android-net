package li.vin.net;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import rx.Subscriber;

import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class) @Config(constants = BuildConfig.class, sdk = 22)
public class ReportCardsIntegrationTests {

  public VinliApp vinliApp;

  @Before public void setup() {
    assertTrue(TestHelper.getAccessToken() != null);

    vinliApp = TestHelper.getVinliApp();
  }

  @Test public void testGetReportCardById() {
    assertTrue(TestHelper.getReportCardId() != null);

    vinliApp.reportCards()
        .reportCard(TestHelper.getReportCardId())
        .toBlocking()
        .subscribe(new Subscriber<Wrapped<ReportCard>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            assertTrue(false);
          }

          @Override public void onNext(Wrapped<ReportCard> reportCardWrapped) {
            ReportCard reportCard = reportCardWrapped.item();

            assertTrue(reportCard.id() != null && reportCard.id().length() > 0);
            assertTrue(reportCard.deviceId() != null && reportCard.deviceId().length() > 0);
            assertTrue(reportCard.vehicleId() != null && reportCard.vehicleId().length() > 0);
            assertTrue(reportCard.tripId() != null && reportCard.tripId().length() > 0);
            assertTrue(reportCard.grade() != null && reportCard.grade().length() > 0);
          }
        });
  }

  @Test public void testGetReportCardsForVehicle() {
    assertTrue(TestHelper.getVehicleId() != null);

    vinliApp.reportCards()
        .reportCardsForVehicle(TestHelper.getVehicleId(), null, null, null, null)
        .toBlocking()
        .subscribe(new Subscriber<TimeSeries<ReportCard>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            assertTrue(false);
          }

          @Override public void onNext(TimeSeries<ReportCard> reportCardTimeSeries) {
            assertTrue(reportCardTimeSeries.getItems().size() > 0);

            for (ReportCard reportCard : reportCardTimeSeries.getItems()) {
              assertTrue(reportCard.id() != null && reportCard.id().length() > 0);
              assertTrue(reportCard.deviceId() != null && reportCard.deviceId().length() > 0);
              assertTrue(reportCard.vehicleId() != null && reportCard.vehicleId().length() > 0);
              assertTrue(reportCard.tripId() != null && reportCard.tripId().length() > 0);
              assertTrue(reportCard.grade() != null && reportCard.grade().length() > 0);
            }
          }
        });
  }

  @Test public void testGetReportCardsForDevice() {
    assertTrue(TestHelper.getDeviceId() != null);

    vinliApp.reportCards()
        .reportCardsForDevice(TestHelper.getDeviceId(), null, null, null, null)
        .toBlocking()
        .subscribe(new Subscriber<TimeSeries<ReportCard>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            assertTrue(false);
          }

          @Override public void onNext(TimeSeries<ReportCard> reportCardTimeSeries) {
            assertTrue(reportCardTimeSeries.getItems().size() > 0);

            for (ReportCard reportCard : reportCardTimeSeries.getItems()) {
              assertTrue(reportCard.id() != null && reportCard.id().length() > 0);
              assertTrue(reportCard.deviceId() != null && reportCard.deviceId().length() > 0);
              assertTrue(reportCard.vehicleId() != null && reportCard.vehicleId().length() > 0);
              assertTrue(reportCard.tripId() != null && reportCard.tripId().length() > 0);
              assertTrue(reportCard.grade() != null && reportCard.grade().length() > 0);
            }
          }
        });
  }

  @Test public void testGetReportCardForTrip() {
    assertTrue(TestHelper.getTripId() != null);

    vinliApp.reportCards()
        .reportCardForTrip(TestHelper.getTripId())
        .toBlocking()
        .subscribe(new Subscriber<Wrapped<ReportCard>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            assertTrue(false);
          }

          @Override public void onNext(Wrapped<ReportCard> reportCardWrapped) {
            ReportCard reportCard = reportCardWrapped.item();

            assertTrue(reportCard.id() != null && reportCard.id().length() > 0);
            assertTrue(reportCard.deviceId() != null && reportCard.deviceId().length() > 0);
            assertTrue(reportCard.vehicleId() != null && reportCard.vehicleId().length() > 0);
            assertTrue(reportCard.tripId() != null && reportCard.tripId().length() > 0);
            assertTrue(reportCard.grade() != null && reportCard.grade().length() > 0);
          }
        });
  }

  @Test public void testOverallReportCard() {
    assertTrue(TestHelper.getDeviceId() != null);

    vinliApp.reportCards()
        .overallReportCardForDevice(TestHelper.getDeviceId())
        .toBlocking()
        .subscribe(new Subscriber<ReportCard.OverallReportCard>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            e.printStackTrace();
            assertTrue(false);
          }

          @Override public void onNext(ReportCard.OverallReportCard overallReportCard) {
            assertTrue(overallReportCard.overallGrade() != null
                && overallReportCard.overallGrade().length() > 0);
            assertTrue(overallReportCard.tripSampleSize() != null);
            assertTrue(overallReportCard.gradeCount().keySet().size() > 0);
          }
        });
  }
}