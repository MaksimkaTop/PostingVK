package com.example.maks.postingvk

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.*
import com.vk.sdk.api.model.VKApiUser
import com.vk.sdk.api.model.VKList
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val scope = arrayOf(VKScope.GROUPS, VKScope.PAGES, VKScope.DIRECT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val fingerprints = VKUtil.getCertificateFingerprint(this, this.packageName)
//        println("NOW IS YOU Key!!!")
//        println(Arrays.asList(*fingerprints!!))

        initVk()


    }

    fun initVk() {
        login_btn.setOnClickListener {
            VKSdk.initialize(applicationContext)
            VKSdk.login(this, *scope)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
                    override fun onResult(res: VKAccessToken) {
                        // Toast.makeText(applicationContext, res.accessToken, Toast.LENGTH_LONG).show()
                        VkRequest()
                    }

                    override fun onError(error: VKError) {
                        Toast.makeText(applicationContext, "Wrong!", Toast.LENGTH_LONG).show()
                    }
                })) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


    private fun VkRequest() {
        val request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, VKApiUser.FIELD_PHOTO_200))
        request.executeWithListener(object : VKRequest.VKRequestListener() {
            override fun onComplete(response: VKResponse?) {
                val user = (response!!.parsedModel as VKList<VKApiUser>)[0]
                //  val userMy = (response.json)  // создать дата класс к запросу, и дату пихать во вью
                val urlImage = user.photo_200
                Glide.with(icon)
                        .load(urlImage)
                        .apply(RequestOptions.circleCropTransform())
                        .into(icon)
            }

            override fun onError(error: VKError?) {}
            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {}
        })
    }
}
