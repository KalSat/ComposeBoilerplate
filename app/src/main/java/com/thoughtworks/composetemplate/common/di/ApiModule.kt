package com.thoughtworks.composetemplate.common.di

import com.thoughtworks.composetemplate.common.network.RetrofitApiFactory
import com.thoughtworks.composetemplate.common.network.animal.CatApi
import com.thoughtworks.composetemplate.common.network.animal.DogApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun providerCatApi(retrofitApiFactory: RetrofitApiFactory): CatApi {
        return retrofitApiFactory.createApi()
    }

    @Singleton
    @Provides
    fun providerDogApi(retrofitApiFactory: RetrofitApiFactory): DogApi {
        return retrofitApiFactory.createApi()
    }

}
