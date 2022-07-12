package com.example.cryptoapp.di


import com.example.cryptoapp.network.NoteAPI
import com.example.cryptoapp.utils.Constants
import com.example.cryptoapp.utils.Constants.BASE_URL
import com.example.cryptoapp.utils.Constants.TIMEOUT_TIME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

//    @Singleton
//    @Provides
//    fun providesRetrofit(): Retrofit.Builder {
//        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//    }
//
//    @Singleton
//    @Provides
//    fun providesNoteAPI(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): NoteAPI {
//        return retrofitBuilder.client(okHttpClient).build().create(NoteAPI::class.java)
//    }
@Singleton
@Provides
fun provideApiService(): NoteAPI {
    val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                ).apply { HttpLoggingInterceptor.Level.BODY }
                .connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return builder.create(NoteAPI::class.java)

}

}