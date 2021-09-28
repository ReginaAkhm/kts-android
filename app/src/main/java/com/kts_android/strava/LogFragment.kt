package com.kts_android.strava

//import androidx.Rebinding.ViewBindings
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.kts_android.strava.R.id.login_btn
import timber.log.Timber


class LogFragment : Fragment() {
    val vm: SavestateModel by viewModels<SavestateModel>()

    private lateinit var login: EditText
    private lateinit var password: EditText


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
        vm.setQuery(login.text.toString())
        vm.setpass(password.text.toString())
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

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView ${hashCode()}")
        val view = inflater.inflate(R.layout.fragment_log, container, false)
        //login_txt = view.findViewById(R.id.login_txt)
        val buttonLog = view.findViewById<Button>(login_btn)
        login = view.findViewById<EditText>(R.id.login_txt)
        password = view.findViewById<EditText>(R.id.password_txt)

        buttonLog.isEnabled = false
        buttonLog.setBackgroundColor(ContextCompat.getColor(buttonLog.context, R.color.gray))

        vm.filteredData.observe(viewLifecycleOwner) {
            login.setText(it)
        }
        vm.filteredData_password.observe(viewLifecycleOwner) {
            password.setText(it)
        }

        fun String.isValidEmail() = isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        fun String.isValidPassword() = this.length >= 8

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val emailString = login.text.toString()
                val passwordString = password.text.toString()
                if (emailString.isValidEmail() && passwordString.isValidPassword()) {
                    buttonLog.isEnabled = true
                    buttonLog.setBackgroundColor(
                        ContextCompat.getColor(
                            buttonLog.context,
                            R.color.purple_700
                        )
                    )
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }


            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                val emailString = login.text.toString()
                val passwordString = password.text.toString()
                if (emailString.isValidEmail() && passwordString.isValidPassword()) {
                    buttonLog.isEnabled = true
                    buttonLog.setBackgroundColor(
                        ContextCompat.getColor(
                            buttonLog.context,
                            R.color.purple_700
                        )
                    )
                }
            }

            override fun afterTextChanged(p0: Editable) {

            }
        })


        buttonLog.setOnClickListener {
            //val isValid = Patterns.EMAIL_ADDRESS.matcher(emailString).matches()

            Navigation.findNavController(view).navigate(R.id.action_logFragment_to_mainFragment)
        }

        // Inflate the layout for this fragment
        return view
    }


}