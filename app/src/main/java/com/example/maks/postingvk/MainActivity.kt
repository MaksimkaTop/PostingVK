package com.example.maks.postingvk

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKApi
import com.vk.sdk.api.VKError
import com.vk.sdk.api.VKParameters
import com.vk.sdk.api.VKRequest
import com.vk.sdk.api.photo.VKImageParameters
import com.vk.sdk.util.VKUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.vk.sdk.api.VKResponse
import com.vk.sdk.api.VKRequest.VKRequestListener




class MainActivity : AppCompatActivity() {
    private val scope = arrayOf(VKScope.GROUPS, VKScope.PAGES, VKScope.DIRECT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VKSdk.initialize(applicationContext);
        setContentView(R.layout.activity_main)
        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)
        println("NOW IS YOU Key!!!")
        println(Arrays.asList(*fingerprints!!))
        VKSdk.login(this, *scope)



    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!// Пользователь успешно авторизовался
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
                    override fun onResult(res: VKAccessToken) {
                        Toast.makeText(applicationContext, res.accessToken, Toast.LENGTH_LONG).show()
                        val request : VKRequest
                        //request = VKApi.groups().get(VKParameters.from())
                        request = VKApi.users().get(VKParameters.from(210700286))
                        test(request)
                    }
                    override fun onError(error: VKError) {
                        Toast.makeText(applicationContext, "Wrong!", Toast.LENGTH_LONG).show()
                    }
                })) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun test(request: VKRequest){
        request.executeWithListener(object : VKRequestListener() {
            override fun onComplete(response: VKResponse?) {
                //Do complete stuff
                tv.text = response?.responseString
            }

            override fun onError(error: VKError?) {
                //Do error stuff
            }

            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {
                //I don't really believe in progress
            }
        })
    }
}
