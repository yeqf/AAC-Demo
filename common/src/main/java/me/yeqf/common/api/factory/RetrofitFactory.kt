package me.yeqf.common.api.factory

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 2018\2\11 0011.
 */
abstract class RetrofitFactory<T> {

    private var mService: T? = null

    abstract val baseUrl: String

    abstract fun getClassType(): Class<T>

    fun makeService(): T {
        if(mService == null) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(OkHttpConfig.client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            mService = retrofit.create(getClassType())
        }
        return mService!!
    }
}