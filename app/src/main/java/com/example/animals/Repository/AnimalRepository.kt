package com.example.animals.Repository
import com.example.animals.Model.Animal
import com.example.animals.Service.RetrofitInstance
import retrofit2.Response

class AnimalRepository {
    private val retrofitInstance = RetrofitInstance
        suspend fun getCats(): Response<List<Animal>> {

        return retrofitInstance.api.getCats()
    }

    suspend fun getDogs(): Response<List<Animal>> {
        return retrofitInstance.api.getDogs()
    }
}
