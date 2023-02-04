package dev.shahbazly.vasoccer.base.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance
import kotlin.properties.Delegates

abstract class BaseDialogFragment<T : BaseViewModel>(private val resId: Int? = null) :
    DialogFragment(),
    FragmentScene {
    protected abstract val viewModel: T

    override val self: Fragment
        get() = this

    private var viewModelFactory: KodeinViewModelFactory by Delegates.notNull()

    var useAsFragment: Boolean = false

    inline fun <reified T : BaseViewModel> viewModel(type: Class<T>): Lazy<T> =
        lazy { `access$provide`(type) }

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val kodein = (activity as KodeinAware).kodein
        viewModelFactory = kodein.direct.instance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = resId?.let { inflater.inflate(resId, container, false) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isCancelable = false

        if (useAsFragment) {
            showsDialog = false
        }
    }

    protected open fun bindViewModel() {
        bindCommand(viewModel.closeCommand) { findNavController().navigateUp() }
        bindCommand(viewModel.showShortToastCommand) { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    protected fun <T : KodeinViewModel> provide(viewModelClass: Class<T>): T {
        return ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }

    @PublishedApi
    internal fun <T : KodeinViewModel> `access$provide`(viewModelClass: Class<T>) =
        provide(viewModelClass)
}

