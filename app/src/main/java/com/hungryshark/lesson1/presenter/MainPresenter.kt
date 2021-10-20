package com.hungryshark.lesson1.presenter

import com.hungryshark.lesson1.model.CountersModel
import com.hungryshark.lesson1.utils.CounterType
import com.hungryshark.lesson1.view.IMainView

class MainPresenter(
    private var view: IMainView?
) {

    private val counters = CountersModel()

    fun counterClick(type: CounterType) {
        val nextValue = when (type) {
            CounterType.COUNTER_OF_DAYS -> counters.next(0)
            CounterType.COUNTER_OF_MINUTES -> counters.next(1)
            CounterType.COUNTER_OF_LIKES -> counters.next(2)
        }
        view!!.setButtonText(type, nextValue.toString())
    }

    fun onAttach(view: IMainView) {
        this.view = view
    }

    fun onDetach() {
        this.view = null
    }
}