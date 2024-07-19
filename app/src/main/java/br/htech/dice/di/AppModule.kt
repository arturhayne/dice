package br.htech.dice.di

import br.htech.dice.data.DiceRepository
import br.htech.dice.data.RealmDiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDiceRepository(): DiceRepository = RealmDiceRepository()
}