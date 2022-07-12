package com.example.cryptoapp.network
import com.example.cryptoapp.model.CryptoValue
import retrofit2.Response
import retrofit2.http.*

interface NoteAPI {

    @GET("/home")
    suspend fun getNotes(): Response<List<CryptoValue>>

}