package dev.shahbazly.vasoccer.ui.webview

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment
import dev.shahbazly.vasoccer.databinding.FragmentWebBinding

const val API_URL = "https://vk.com/shahbazly"
const val LOAD_WITH_OVERVIEW_MODE = true
const val USE_WIDE_VIEWPORT = false
const val BUILT_IN_ZOOM_CONTROLS = true
const val DISPLAY_ZOOM_CONTROLS = false

class WebFragment : BaseDialogFragment<WebViewModel>(R.layout.fragment_web) {
    override val viewModel: WebViewModel by viewModel(WebViewModel::class.java)

    private val binding: FragmentWebBinding by viewBinding()

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.browserWebView.canGoBack()) {
                binding.browserWebView.goBack()
            } else
                parentFragmentManager.popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(callback)

        initViews()
        bindViewModel()
    }

    override fun bindViewModel() {
        super.bindViewModel()

        with(viewModel) {
            bindVisible(progressViewVisible, binding.contentLoadingProgressBar)
            bind(pageLoadingProgress) {
                binding.contentLoadingProgressBar.progress = it
            }
        }
    }

    private fun initViews() {
        with(binding) {
            browserWebView.loadUrl(API_URL)

            browserWebView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return false
                }
            }

            browserWebView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(wv: WebView, progress: Int) {
                    viewModel.changeProgress(progress)
                }
            }

            browserWebView.settings.apply {
                loadWithOverviewMode = LOAD_WITH_OVERVIEW_MODE
                useWideViewPort = USE_WIDE_VIEWPORT
                builtInZoomControls = BUILT_IN_ZOOM_CONTROLS
                displayZoomControls = DISPLAY_ZOOM_CONTROLS
            }
        }
    }

    companion object {
        const val TAG = "WEB_FRAGMENT"

        fun newInstance() = WebFragment()
    }

}