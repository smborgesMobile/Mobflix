package br.com.mobflix.di

import br.com.mobflix.ui.screen.viewmodel.AddVideoScreenViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

class AppModule {

    fun loadModules() =
        loadKoinModules(module {
            provideViewModel()
        })

    private fun Module.provideViewModel() {
        viewModel { AddVideoScreenViewModel(dispatcher = Dispatchers.Default) }
    }
}