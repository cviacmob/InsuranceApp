package com.insurance.insuranceapp.RestAPI;

import com.insurance.insuranceapp.Datamodel.ProfileInfo;
import com.insurance.insuranceapp.Datamodel.RegistrationInfo;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Balaji on 4/16/2018.
 */

public interface InsuranceAPI {

    @POST("/insapi/index.php/login")
    Call<ProfileInfo> getlogin(@Body RegistrationInfo registrationInfo);
}
