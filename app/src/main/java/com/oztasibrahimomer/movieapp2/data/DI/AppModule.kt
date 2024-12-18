package com.oztasibrahimomer.movieapp2.data.DI

import com.oztasibrahimomer.movieapp2.data.remote.service.MovieAPI
import com.oztasibrahimomer.movieapp2.data.repository.MovieRepositoryImpl
import com.oztasibrahimomer.movieapp2.domain.repository.MovieRepository
import com.oztasibrahimomer.movieapp2.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieAPI() :MovieAPI {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)

    }


    @Provides
    @Singleton
    fun provideMovieRepository(api:MovieAPI):MovieRepository {
        return MovieRepositoryImpl(api=api)
    }
}