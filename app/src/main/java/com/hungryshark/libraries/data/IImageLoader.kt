package com.hungryshark.libraries.data

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}