package dev.shahbazly.vasoccer.base.common

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class KodeinActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId), KodeinAware {

    final override val kodein by closestKodein()
}