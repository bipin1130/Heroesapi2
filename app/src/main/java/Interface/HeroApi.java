package Interface;

import java.util.List;

import model.Hero;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HeroApi {
    @FormUrlEncoded
    @POST ("heroes")
    Call<Void> addHero(@Field("name") String name, @Field("desc") String desc);

    @GET("heroes")
    Call<List<Hero>> getHero();

}
