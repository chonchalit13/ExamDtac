package th.co.toei.examdtac.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import th.co.toei.examdtac.model.Result
import th.co.toei.examdtac.network.EndpointInterface

class MainViewModel(private val apiService: EndpointInterface) : ViewModel() {

    val contactsLiveData: MutableLiveData<MutableList<Result>> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    val compositeDisposable = CompositeDisposable()

    fun getContactsData(input: Int) {
        val callService = apiService.getContactData(input)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                contactsLiveData.postValue(it.results)
            }, {
                errorLiveData.postValue(it.message)
            })
        compositeDisposable.add(callService)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}