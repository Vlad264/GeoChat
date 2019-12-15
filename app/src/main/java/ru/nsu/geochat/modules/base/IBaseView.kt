package ru.nsu.geochat.modules.base

interface IBaseView<in T: IBasePresenter> {
    fun setPresenter(presenter: T)
}