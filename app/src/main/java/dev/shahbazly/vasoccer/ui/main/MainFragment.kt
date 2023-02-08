package dev.shahbazly.vasoccer.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment
import dev.shahbazly.vasoccer.databinding.FragmentMainBinding
import dev.shahbazly.vasoccer.ui.main.adapter.MatchAdapter

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
        }
    }

    companion object {
        const val TAG = "MAIN_FRAGMENT"

        fun newInstance() = MainFragment()
    }
}