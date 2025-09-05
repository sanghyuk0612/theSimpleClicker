package com.example.theroulettegame.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MoneyViewModel : ViewModel() {
    // 내부 MutableStateFlow 선언 및 초기값 설정
    private val _holdMoney = MutableStateFlow(0)
    val holdMoney: StateFlow<Int> = _holdMoney.asStateFlow()

    private val _secondMoney = MutableStateFlow(0)
    val secondMoney: StateFlow<Int> = _secondMoney.asStateFlow()

    private val _clickMoney = MutableStateFlow(1)
    val clickMoney: StateFlow<Int> = _clickMoney.asStateFlow()

    private val _secondUpgradeCost = MutableStateFlow(10)
    val secondUpgradeCost = _secondUpgradeCost.asStateFlow()

    private val _clickUpgradeCost = MutableStateFlow(10)
    val clickUpgradeCost = _clickUpgradeCost.asStateFlow()

    fun setHoldMoney(value: Int) {
        viewModelScope.launch {
            _holdMoney.value = value
        }
    }

    fun setSecondMoney(value: Int) {
        viewModelScope.launch {
            _secondMoney.value = value
        }
    }

    fun setClickMoney(value: Int) {
        viewModelScope.launch {
            _clickMoney.value = value
        }
    }
    fun setSecondUpgradeMoney(value: Int) {
        viewModelScope.launch {
            _secondUpgradeCost.value = value
        }
    }
    fun setClickUpgradeMoney(value: Int) {
        viewModelScope.launch {
            _clickUpgradeCost.value = value
        }
    }

}
