package ru.maxmvaas.lesson_7_vasilev.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.maxmvaas.lesson_7_vasilev.data.BridgeStatus
import ru.maxmvaas.lesson_7_vasilev.data.remote.BridgesApi

class BridgeListViewModel : ViewModel() {
    private val _bridgeListStateLiveData = MutableLiveData<BridgeStatus>()
    val bridgeListStatusLiveData: LiveData<BridgeStatus> = _bridgeListStateLiveData

    fun loadBridges() {
        viewModelScope.launch {
            try {
                _bridgeListStateLiveData.postValue(BridgeStatus.Loading)
                val bridges = BridgesApi.apiService.getBridges()
                _bridgeListStateLiveData.postValue(BridgeStatus.Data(bridges))
            } catch (e: Exception) {
                _bridgeListStateLiveData.postValue(BridgeStatus.Error(e))
            }
        }
    }
}