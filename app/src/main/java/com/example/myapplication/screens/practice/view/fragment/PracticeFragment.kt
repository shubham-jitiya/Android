package com.example.myapplication.screens.practice.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPracticeBinding
import com.example.myapplication.screens.practice.model.api.RetrofitInstance
import com.example.myapplication.screens.practice.model.api.UsersPostApiService
import com.example.myapplication.screens.practice.model.dataclass.Post
import com.example.myapplication.screens.practice.model.repository.PostRepository
import com.example.myapplication.screens.practice.model.repository.UserRepository
import com.example.myapplication.screens.practice.viewmodel.PostViewModel
import com.example.myapplication.screens.practice.viewmodel.PostViewModelFactory
import com.example.myapplication.screens.practice.viewmodel.UsersViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.json.JSONException
import org.json.JSONObject

class PracticeFragment : Fragment() {
    private lateinit var binding: FragmentPracticeBinding
    private lateinit var postViewModel: PostViewModel
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_practice, container, false)

        setupViewModel()
        setupPostsObserver()
        encodeWithSerialization()
        decodeWithSerialization()
        encodeWithJsonObject()
        decodeWithJsonObject()

        binding.buttonSearch.setOnClickListener {
            val id = binding.editTextUserId.text.toString()
            if (id.isNotEmpty()) {
                postViewModel.getSpecificPost(id.toInt())
            }
        }

        binding.buttonPushPost.setOnClickListener {
            val post = Post(1, 100, "SD", "Android developer")
            postViewModel.pushPost(post)
        }

        binding.buttonGetAllPosts.setOnClickListener { postViewModel.getPosts() }

        binding.buttonPushPostEncrypted.setOnClickListener {
            val post = Post(1, 100, "SD", "Android developer")
            postViewModel.pushEncryptedPost(post)
        }

        binding.buttonSearchPost.setOnClickListener {
            postViewModel.searchPost(3)
        }

        binding.buttonSortPost.setOnClickListener {
            sortByMap()
        }
        postViewModel.fetchWithOkHttp()
        // http url connection
        usersViewModel.fetchUsers()
        postViewModel.sortPost(2, "id", "desc")

        return binding.root
    }

    private fun setupPostsObserver() {
        // posts/search/sort by map, sort post observer
        postViewModel.posts.observe(this) {
            binding.textViewResult.text = it.toString()
        }

        // specific post observer
        postViewModel.specificPost.observe(this) {
            binding.textViewResult.text = it.title
        }

        // push post observer
        postViewModel.postResponse.observe(this) {
            binding.textViewResult.text = it.toString()
        }

        // push post/encrypted post observer
        postViewModel.postResponse.observe(this) {
            binding.textViewResult.text = it.toString()
        }

        // HTTP URL
        usersViewModel.usersList.observe(this) {
            Log.d("TAG", "handleApiRequest: ${it.data.first().first_name}")
        }
    }


    private fun encodeWithJsonObject() {
        val json = JSONObject()
        json.put("name", "Shubham Jitiya")
        json.put("age", 21)
        val encodedJson = json.toString()
        Log.d("TAG", "encodeWithJsonObject: $encodedJson")
    }

    private fun decodeWithJsonObject() {
        val jsonString =
            "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"TokeepReqResfree,contributionstowardsservercostsareappreciated!\"}}"
        val jsonObject = JSONObject(jsonString)
        try {
            val dataObject = jsonObject.getJSONObject("data")
            Log.d("TAG", "parseJsonWithJsonObject: $dataObject")
            Log.d("TAG", "parseJsonWithJsonObject: ${dataObject.getString("first_name")}")
        } catch (error: JSONException) {
            Log.d("TAG", "decodeWithJsonObject: ${error.localizedMessage}")
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun decodeWithSerialization() {
        val json =
            Json.decodeFromString<Post>("{\"id\":1,\"userId\":100,\"title\":\"SD\",\"body\":\"iOS developer\"}")
        Log.d("TAG", "decodeWithJsonObject: ${json.body}")
    }

    private fun encodeWithSerialization() {
        val post = Post(1, 100, "SD", "Android developer")
        val json = Json.encodeToString(serializer(), post)
        Log.d("TAG", "pushPost json: $json")
    }

    private fun sortByMap() {
        val map: HashMap<String, String> = HashMap()
        map["_sort"] = "id"
        map["_order"] = "desc"
        postViewModel.sortPostByMap(3, map)
    }

    private fun setupViewModel() {
        // Posts API
        val postApiService = RetrofitInstance.instance.create(UsersPostApiService::class.java)
        val repository = PostRepository(postApiService)
        postViewModel =
            ViewModelProvider(this, PostViewModelFactory(repository))[PostViewModel::class.java]
        // Users API
        usersViewModel = UsersViewModel(UserRepository())
    }
}