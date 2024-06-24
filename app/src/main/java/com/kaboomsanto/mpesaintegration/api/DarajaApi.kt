package com.kaboomsanto.mpesaintegration.api

import com.kaboomsanto.mpesaintegration.model.AccessTokenResponse
import com.kaboomsanto.mpesaintegration.model.STKPushRequest
import com.kaboomsanto.mpesaintegration.model.STKPushResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DarajaApi {
    @GET("oauth/v1/generate?grant_type=client_credentials")
    suspend fun getAccessToken(
        @Header("Authorization") auth: String): Response<AccessTokenResponse>


    @POST("mpesa/stkpush/v1/processrequest")
    suspend fun sendSTKPush(
        @Header("Authorization") auth: String,
        @Body stkPushRequest: STKPushRequest): Response<STKPushResponse>



}