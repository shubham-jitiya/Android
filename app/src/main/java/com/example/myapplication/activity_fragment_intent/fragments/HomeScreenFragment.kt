package com.example.myapplication.activity_fragment_intent.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment(), DataPassBook {
    private lateinit var binding: FragmentHomeScreenBinding
    private var dataPassListener: DataPassListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        handleSwitchFragments()
        // handleOnBackPressed() // handles child fragment backstack
        return binding.root
    }

    private fun handleOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (childFragmentManager.backStackEntryCount == 0 && parentFragmentManager.backStackEntryCount == 0) {
                        // Handle back to home navigation
                    } else {
                        childFragmentManager.popBackStack()
                    }
                }
            })
    }

    private fun handleSwitchFragments() {
        binding.buttonBooks.setOnClickListener {
            replaceFragment(BooksFragment())
        }
        binding.buttonChats.setOnClickListener {
            replaceFragment(ChatsFragment())
        }
        updateButtonText()
    }

    private fun updateButtonText() {
        binding.radioGroupDataPassing.setOnCheckedChangeListener { _, i ->
            val selectedRadioButton = view?.findViewById<AppCompatRadioButton>(i)
            dataPassListener?.passData(selectedRadioButton?.text.toString())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerHomeScreen, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DataPassListener) {
            dataPassListener = context
        } else {
            Toast.makeText(
                context,
                "Parent activity doesn't implements this interface",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDetach() {
        super.onDetach()
        dataPassListener = null
    }

    override fun bookName(name: String) {
        val fragmentChat = ChatsFragment()
        val bundle = Bundle()
        bundle.putString("Name", name)
        fragmentChat.arguments = bundle
    }
}

interface DataPassListener {
    fun passData(message: String)
}
