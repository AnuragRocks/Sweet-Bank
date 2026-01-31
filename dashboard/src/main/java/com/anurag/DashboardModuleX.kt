package com.anurag

import com.anurag.ui.DashboardFragment
import com.anurag.ui.HomepageActivity
import org.koin.dsl.module

val dashboardModule = module {
    factory { HomepageActivity() }
    factory { DashboardFragment() }
}
