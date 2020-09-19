package com.stochanskyi.itunescharts.data.network.common

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.stochanskyi.itunescharts.data.network.features.charts.ChartsApi
import com.stochanskyi.itunescharts.data.network.features.info.ArtworkInfoApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAdapter {
    companion object {
        private const val CHARTS_URL = "https://rss.itunes.apple.com/api/v1/us/"
        private const val ITUNES_URL = "http://itunes.apple.com/"
    }

    private val chartsClient = createRetrofitClient(CHARTS_URL)

    private val iTunesClient = createRetrofitClient(ITUNES_URL)

    val chartsApiService: ChartsApi = chartsClient.create(ChartsApi::class.java)

    val infoApiService: ArtworkInfoApi = chartsClient.create(ArtworkInfoApi::class.java)

    private fun createRetrofitClient(url: String) = Retrofit.Builder()
        .baseUrl(url)
        .client(createHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun createHttpClient() = OkHttpClient.Builder()
        .addInterceptor(createLoggingInterceptor())
        .build()

}