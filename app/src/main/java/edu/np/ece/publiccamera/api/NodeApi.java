package edu.np.ece.publiccamera.api;

import edu.np.ece.publiccamera.model.Node;
import edu.np.ece.publiccamera.model.NodeList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zqi2 on 20/5/2016.
 */
public interface NodeApi {

    @GET("nodes/{id}")
    Call<Node> get(@Path("id") String id);

    @GET("nodes")
    Call<NodeList> list();

    @GET("nodes/search")
    Call<NodeList> searchByProject(@Query("projectId") Integer projectId);

    @GET("nodes/search")
    Call<NodeList> searchByFloor(@Query("floorId") Integer floorId);

}
