package edu.np.ece.publiccamera.api;

import edu.np.ece.publiccamera.model.Floor;
import edu.np.ece.publiccamera.model.FloorList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zqi2 on 20/5/2016.
 */
public interface FloorApi {

    @GET("floors/{id}")
    Call<Floor> get(@Path("id") String id);

    @GET("floors")
    Call<FloorList> list();

    @GET("floors/search")
    Call<FloorList> searchByProject(@Query("projectId") Integer projectId);


}
