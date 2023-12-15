package cz.utb.fai.subjectinfo

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.utb.fai.subjectinfo.domain.SubjectInfoDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


class SubjectInfoViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _subjectInfoValue = MutableLiveData<SubjectInfoDomain>()
    val subjectInfoValue: LiveData<SubjectInfoDomain> = _subjectInfoValue

    val showHint = MutableLiveData<Boolean>()
    val showNotFound = MutableLiveData<Boolean>()
    val showProgressBar = MutableLiveData<Boolean>()
    val zkratkaMutable = MutableLiveData<String?>()

    val processToDetail = MutableLiveData<Boolean>()



    fun getSubjectInfo(katedra: String, zkratka: String){
        viewModelScope.launch {
            try {

                _subjectInfoValue.value = repository.getSubjectInfo(katedra, zkratka).firstOrNull()
                showProgressBar.value = false
            } catch (e: Exception) {
                Log.v("MYAPP", "Not found: " + e.message)

                // show not found message
                showNotFound.value = true
                showProgressBar.value = false
            }
        }
    }

    fun search () {
        if (zkratkaMutable.value != null && !zkratkaMutable.value!!.isEmpty()) {
            // zkratka was provided by the user
            showProgressBar.value = true
            getSubjectInfo("AUIUI", zkratkaMutable.value!!)

        } else {
            // zkratka was not provided, show hint text view
            showHint.value = true
        }
    }

    fun toDetail () {
        processToDetail.value = true
    }

    fun hideHintAndNotFound () {
        showHint.value = false
        showNotFound.value = false
    }
}