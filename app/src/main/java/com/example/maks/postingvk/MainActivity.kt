package com.example.maks.postingvk

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import com.vk.sdk.util.VKUtil
import java.util.*


class MainActivity : AppCompatActivity() {
    private val scope = arrayOf(VKScope.PHOTOS, VKScope.WALL, VKScope.DIRECT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)
        println("NOW IS YOU Key!!!")
        println(Arrays.asList(*fingerprints!!))

        VKSdk.login(this, *scope)

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
//        if (!// Пользователь успешно авторизовался
//                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
//                VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
//                    override fun onResult(res: VKAccessToken) {
//                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
//                    }
//
//                    override fun onError(error: VKError) {
//                        Toast.makeText(applicationContext, "Wrong!", Toast.LENGTH_LONG).show()
//                    }
//                })) {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
}
