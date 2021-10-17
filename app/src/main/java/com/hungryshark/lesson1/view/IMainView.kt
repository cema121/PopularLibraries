package com.hungryshark.lesson1.view

import com.hungryshark.lesson1.utils.CounterType

interface IMainView {
    fun setButtonText(type: CounterType, text: String)
}