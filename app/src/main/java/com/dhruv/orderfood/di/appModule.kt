package com.dhruv.orderfood.di

import androidx.room.Room
import com.dhruv.orderfood.data.db.Db
import com.dhruv.orderfood.data.db.LocalDataSource
import com.dhruv.orderfood.data.pref.PrefDataSource
import com.dhruv.orderfood.data.repository.AppRepository
import com.dhruv.orderfood.data.repository.RemoteDataSource
import com.dhruv.orderfood.data.repository.Repository
import com.dhruv.orderfood.data.repository.RetrofitBuilder
import com.dhruv.orderfood.viewmodels.CategoryHomeViewModel
import com.dhruv.orderfood.viewmodels.LoginViewModel
import com.dhruv.orderfood.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteModule = module {
    single {
        RetrofitBuilder.apiService
    }
}

val remoteDataSource= module {
    single { RemoteDataSource(get()) }
}

val repositoryModule = module {
    single<Repository> { AppRepository(get(), get(),get()) }
}

val persistenceModule = module {
    single { PrefDataSource() }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), Db::class.java, "order_grubber")
            .fallbackToDestructiveMigration().build()
    }
    single { get<Db>().screenServerDao() }
}

val dataSourceModule = module {
    single { LocalDataSource(get()) }
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { CategoryHomeViewModel(get()) }
}

val appModule =
    listOf(persistenceModule, databaseModule, dataSourceModule, repositoryModule, viewModelModule,remoteDataSource,remoteModule)