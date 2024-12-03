package com.example.animals.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animals.Model.Animal
import com.example.animals.Repository.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {

    val cats = MutableLiveData<List<Animal>>()
    val dogs = MutableLiveData<List<Animal>>()
    val errorMessage = MutableLiveData<String>()

    fun fetchCats() {
        viewModelScope.launch {
            try {
                val response = repository.getCats()
                if (response.isSuccessful) {
                    cats.postValue(response.body())
                } else {
                    errorMessage.postValue("Erreur lors du chargement des chats")
                }
            } catch (e: Exception) {
                errorMessage.postValue(e.localizedMessage)
            }
        }
    }

    fun fetchDogs() {
        viewModelScope.launch {
            try {
                val response = repository.getDogs()
                if (response.isSuccessful) {
                    dogs.postValue(response.body())
                } else {
                    errorMessage.postValue("Erreur lors du chargement des chiens")
                }
            } catch (e: Exception) {
                errorMessage.postValue(e.localizedMessage)
            }
        }
    }
}
