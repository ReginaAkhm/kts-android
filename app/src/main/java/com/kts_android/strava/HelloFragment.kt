package com.kts_android.strava

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import timber.log.Timber


class HelloFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate ${hashCode()}")
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView ${hashCode()}")
        val view = inflater.inflate(R.layout.fragment_hello, container, false)
        val buttonLog = view.findViewById<Button>(R.id.Login_button)
        buttonLog.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_logFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach ${hashCode()}")
//        Timber.d("Fragment1", "onAttach")
    }

    override fun onStart() {
        super.onStart()
//        Timber.d("Fragment1", "onStart")
        Timber.d("onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume ${hashCode()}")
//        Log.d("Fragment1", "onResume")
//        Timber.d("Fragment1", "onResume")
    }

    override fun onStop() {
        Timber.d("onStop ${hashCode()}")
//        Timber.d("Fragment1", "onStop")
//        Log.d("Fragment1", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Timber.d("onDestroyView ${hashCode()}")
//        Timber.d("Fragment1", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Timber.d("onDestroy ${hashCode()}")

        super.onDestroy()
    }

    override fun onDetach() {
//        Timber.d("Fragment1", "onDetach")
        Timber.d("onDetach ${hashCode()}")
//        Log.d("Fragment1", "onDetach")
        super.onDetach()

    }


}