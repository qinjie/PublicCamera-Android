package edu.np.ece.publiccamera.api;

import edu.np.ece.publiccamera.model.Project;
import edu.np.ece.publiccamera.model.ProjectList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zqi2 on 20/5/2016.
 */
public interface ProjectApi {

    @GET("projects/{id}")
    Call<Project> get(@Path("id") String id);

    @GET("projects")
    Call<ProjectList> list();
}
