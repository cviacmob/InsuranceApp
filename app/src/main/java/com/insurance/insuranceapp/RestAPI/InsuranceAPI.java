package com.insurance.insuranceapp.RestAPI;

import com.insurance.insuranceapp.Datamodel.PendingCaseListInfo;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.Datamodel.ProfileInfo;
import com.insurance.insuranceapp.Datamodel.RegistrationInfo;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by Balaji on 4/16/2018.
 */

public interface InsuranceAPI {

    @POST("/insapi/index.php/login")
    Call<ProfileInfo> getlogin(@Body RegistrationInfo registrationInfo);
    @FormUrlEncoded
    @POST("/insapi/index.php/cases")
    Call<List<PendingCaseListInfo>> getpendinglist(@Field("consultant_id") String consultant_id,
                                                   @Field("status") String status);
    @FormUrlEncoded
    @POST("/insapi/index.php/savestatus")
    Call<List<String>> getsavedata( @Field("consultant_id") String consultant_id,
                                    @Field("assign_status") String status,
                                    @Field("case_id") String caseid,
                                    @Field("case_assignment_id") String assignment_id,
                                    @Field("other_case_type_id") String othercasetypeid,
                                    @Field("case_type") String casetype);

}
