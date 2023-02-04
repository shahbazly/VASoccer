package dev.shahbazly.vasoccer.ui.splash

import android.os.CountDownTimer
import androidx.fragment.app.commit
import dev.shahbazly.vasoccer.R
import dev.shahbazly.vasoccer.base.common.BaseDialogFragment
import dev.shahbazly.vasoccer.ui.main.MainFragment

class SplashFragment : BaseDialogFragment<SplashViewModel>(R.layout.fragment_splash) {
    override val viewModel: SplashViewModel by viewModel(SplashViewModel::class.java)

    private val countDownTimer = object : CountDownTimer(2000L, 100L) {
        override fun onFinish() = navigateToMainScreen()
        override fun onTick(p0: Long) {}
    }

    private fun navigateToMainScreen() = parentFragmentManager.commit {
        setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
        replace(
            R.id.fragmentContainer,
            MainFragment.newInstance(),
            MainFragment.TAG
        )
        setReorderingAllowed(true)
        addToBackStack(MainFragment.TAG)
    }

    override fun onStart() {
        super.onStart()
        countDownTimer.start()
    }

    override fun onPause() {
        super.onPause()
        countDownTimer.cancel()
    }

}