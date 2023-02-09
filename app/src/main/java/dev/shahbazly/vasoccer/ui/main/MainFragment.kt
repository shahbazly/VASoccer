package dev.shahbazly.vasoccer.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DefaultItemAnimator
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment
import dev.shahbazly.vasoccer.databinding.FragmentMainBinding
import dev.shahbazly.vasoccer.ui.main.adapter.MatchAdapter
import dev.shahbazly.vasoccer.ui.webview.WebFragment

class MainFragment : BaseDialogFragment<MainViewModel>(R.layout.fragment_main) {
    override val viewModel: MainViewModel by viewModel(MainViewModel::class.java)
    private val viewBinding: FragmentMainBinding by viewBinding()

    private val matchAdapter = MatchAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        bindViewModel()
    }

    override fun bindViewModel() {
        super.bindViewModel()

        with(viewModel) {
            bindVisible(loadingProgressBarVisible, viewBinding.loadingProgressBar)
            bindVisible(errorMessageTextVisible, viewBinding.errorMessageTextView)

            bind(matchesDataList) {
                matchAdapter.submitList(it)
            }
        }
    }

    private fun initViews() {
        with(viewBinding) {
            matchesRecyclerView.adapter = matchAdapter
            matchesRecyclerView.itemAnimator = DefaultItemAnimator()

            apiDocsButton.setOnClickListener {
                navigateToWebApiScreen()
            }
        }
    }

    private fun navigateToWebApiScreen() = parentFragmentManager.commit {
        setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
        replace(
            R.id.fragmentContainer,
            WebFragment.newInstance(),
            WebFragment.TAG
        )
        setReorderingAllowed(true)
        addToBackStack(WebFragment.TAG)
    }

    companion object {
        const val TAG = "MAIN_FRAGMENT"

        fun newInstance() = MainFragment()
    }
}