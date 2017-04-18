package com.example.admin.callingstuff.rest;

import com.example.admin.callingstuff.models.MiniStatement;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mayur on 18/04/17.
 */

public interface ApiInterface {

    @GET("https://retailbanking.mybluemix.net/banking/icicibank/recenttransaction?client_id=rishabh19038@yahoo.in&token=B5C91F7F&accountno=")
    Call<MiniStatement> getMini();
}
