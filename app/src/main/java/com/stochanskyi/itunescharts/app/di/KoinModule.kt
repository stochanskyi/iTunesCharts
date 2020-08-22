package com.stochanskyi.itunescharts.app.di

import org.koin.core.module.Module
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module

abstract class KoinModule(declaration: ModuleDeclaration) {
    val module =  module(moduleDeclaration = declaration)
}