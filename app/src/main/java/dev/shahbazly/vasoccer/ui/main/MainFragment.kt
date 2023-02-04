package dev.shahbazly.vasoccer.ui.main

import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment
import dev.shahbazly.vasoccer.databinding.FragmentMainBinding

class MainFragment : BaseDialogFragment<MainViewModel>(R.layout.fragment_main) {
    override val viewModel: MainViewModel by viewModel(MainViewModel::class.java)
    private val viewBinding: FragmentMainBinding by viewBinding(CreateMethod.INFLATE)

    companion object {
        const val TAG = "MAIN_FRAGMENT"

        fun newInstance() = MainFragment()
    }
}