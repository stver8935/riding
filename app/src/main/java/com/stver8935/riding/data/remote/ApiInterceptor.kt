package com.stver8935.riding.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor {

    inner class ProtectedHeader(private val accessToken: String): Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Authorization","Bearer $accessToken")
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .build()
            return chain.proceed(request)
        }
    }

    inner class PublicHeader: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .build()
            return chain.proceed(request)
        }
    }

    /***
     * 로깅 용도로 사용
     */
    inner class OutBoundInterceptor: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val response =  chain.proceed(chain.request())
            //response.code()
            //response.body()
            response.headers()
            return response
        }

    }


}