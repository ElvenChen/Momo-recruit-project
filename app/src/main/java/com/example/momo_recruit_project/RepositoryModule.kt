package com.example.momo_recruit_project

import android.content.Context
import androidx.room.Dao
import com.example.momo_recruit_project.data.source.DefaultMomoRepository
import com.example.momo_recruit_project.data.source.MomoDataSource
import com.example.momo_recruit_project.data.source.MomoRepository
import com.example.momo_recruit_project.data.source.local.MomoDatabase
import com.example.momo_recruit_project.data.source.local.MomoDatabaseDao
import com.example.momo_recruit_project.data.source.local.MomoLocalDataSource
import com.example.momo_recruit_project.data.source.remote.MomoRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RemoteDataSource

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LocalDataSource

    @Singleton
    @Provides
    @RemoteDataSource
    fun provideMomoRemoteDataSource(): MomoDataSource {
        return MomoRemoteDataSource
    }

    @Singleton
    @Provides
    @LocalDataSource
    fun provideMomoLocalDataSource(dao: MomoDatabaseDao): MomoDataSource {
        return MomoLocalDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideMomoLocalDataSourceDao(@ApplicationContext context: Context): MomoDatabaseDao {
        return MomoDatabase.getInstance(context).momoDatabaseDao
    }

    @Singleton
    @Provides
    fun provideMomoRepository(
        @RemoteDataSource momoRemoteDataSource: MomoDataSource,
        @LocalDataSource momoLocalDataSource: MomoDataSource
    ): MomoRepository {
        return DefaultMomoRepository(momoRemoteDataSource, momoLocalDataSource)
    }

}