package li.vin.net;

import java.util.List;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by tbrown on 3/22/16.
 */
public interface Distances {

  @GET("/vehicles/{vehicleId}/distances")
  Observable<List<Distance>> distances(
      @Path("vehicleId") String vehicleId,
      @Query("from") String from,
      @Query("until") String until);

  @POST("/vehicles/{vehicleId}/odometers")
  Observable<Object> createOdometerReport(
      @Path("vehicleId") String vehicleId,
      @Body Object odometer);

  @GET("/vehicles/{vehicleId}/odometers")
  Observable<Object> odometerReports(
      @Path("vehicleId") String vehicleId);

  @GET("/odometers/{odometerId}")
  Observable<Object> odometerReport(
      @Path("odometerId") String odometerId);

  @DELETE("/odometers/{odometerId}")
  Observable<Object> deleteOdometerReport(
      @Path("odometerId") String odometerId);

  @POST("/vehicles/{vehicleId}/odometer_triggers")
  Observable<Object> createOdometerTrigger(
      @Path("vehicleId") String vehicleId,
      @Body Object odometerTrigger);

  @GET("/odometer_triggers/{odometerTriggerId}")
  Observable<Object> odometerTrigger(
      @Path("odometerTriggerId") String odometerTriggerId);

  @DELETE("/odometer_triggers/{odometerTriggerId}")
  Observable<Object> deleteOdometerTrigger(
      @Path("odometerTriggerId") String odometerTriggerId);

  @GET("/vehicles/{vehicleId}/odometer_triggers")
  Observable<Object> odometerTriggers(
      @Path("vehicleId") String vehicleId);
}
