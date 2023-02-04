package dev.shahbazly.vasoccer.ui.main

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.databinding.MainFragmentBinding
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment

class MainFragment : BaseDialogFragment<MainViewModel>(R.layout.main_fragment) {
    override val viewModel: MainViewModel by viewModel(MainViewModel::class.java)
    private val viewBinding: MainFragmentBinding by viewBinding(CreateMethod.INFLATE)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    private fun navigateToCoinDetails(coin: Coin) = parentFragmentManager.commit {
//        setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
//        replace(
//            R.id.fragmentContainer,
//            DetailsFragment.newInstance(coin),
//            DetailsFragment.TAG
//        )
//        setReorderingAllowed(true)
//        addToBackStack(DetailsFragment.TAG)
//    }

}