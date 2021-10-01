package pro.jsandoval.poctoken

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.HiltAndroidApp
import pro.jsandoval.poctoken.BuildConfig.DEBUG
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initAppCenter()
    }

    private fun initAppCenter() {
        AppCenter.start(
            this, "9d364f2b-295b-4aea-aafd-f167c9a53833",
            Analytics::class.java, Crashes::class.java
        )
    }

}