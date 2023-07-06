package com.example.myapplication.webservice.screens.practice.model.repository

import android.util.Log
import com.example.myapplication.webservice.screens.practice.model.api.UsersApiService
import com.example.myapplication.webservice.screens.userslist.model.dataclass.UsersList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class UserRepository: UsersApiService {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getUsers(): UsersList? = withContext(Dispatchers.IO) {
        // open connection
        val url = URL("https://reqres.in/api/users")
        val connection = url.openConnection() as? HttpsURLConnection

        // setup connection
        connection?.requestMethod = "GET"
        connection?.connectTimeout = 5000
        connection?.readTimeout = 5000

        // check response - success
        val responseCode = connection?.responseCode
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            // read response
            try {
                val inputStream = InputStreamReader(connection.inputStream)
                val response = inputStream.buffered().use { it.readText() }
                // decode json to object
                val usersResponse = Json.decodeFromString<UsersList>(response)
                inputStream.close()
                return@withContext usersResponse
            } catch (e: Exception) {
                Log.d("TAG", "getUsers: ${e.localizedMessage}")
            } finally {
                // close connection
                connection.disconnect()
            }
        } else {
            Log.d("TAG", "getUsers: Invalid response: $responseCode")
        }
        return@withContext null
    }
}