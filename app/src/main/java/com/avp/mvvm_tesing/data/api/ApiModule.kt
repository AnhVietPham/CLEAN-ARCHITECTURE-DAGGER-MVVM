package com.avp.mvvm_tesing.data.api

import android.app.Application
import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        okHttpClientBuilder.readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        okHttpClientBuilder.addInterceptor(logging)
        return okHttpClientBuilder.build()
    }

    @Provides
    fun provideRestApi(application: Application, okHttpClient: OkHttpClient): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.client(okHttpClient)
            .baseUrl("https://mapi.sendo.vn")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitBuilder.build()
    }

    @Provides
    fun provideRemoteHomeApiService(retrofit: Retrofit): RemoteHomeApiService {
        return retrofit.create(RemoteHomeApiService::class.java)
    }


}