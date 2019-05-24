package com.avp.mvvm_tesing.di.module

import com.avp.mvvm_tesing.App
import com.avp.mvvm_tesing.data.api.remote.RemoteHomeApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App {
        return app
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        okHttpClientBuilder.readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        okHttpClientBuilder.addInterceptor(logging)
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("User-Agent", "com.sendo.buyer/v3.0")
                .addHeader("Accept", "application/json").build()
            chain.proceed(request)
        }
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRestApi(okHttpClient: OkHttpClient): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.client(okHttpClient)
            .baseUrl("http://mapi-pilot.sendo.vn/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofitBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRemoteHomeApiService(retrofit: Retrofit): RemoteHomeApiService {
        return retrofit.create(RemoteHomeApiService::class.java)
    }
}