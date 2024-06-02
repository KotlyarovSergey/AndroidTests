package com.ksv.myapplication.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import com.ksv.myapplication.ThirdActivity

class ThirdActivityContractSimple: ActivityResultContract<Int, String?>() {
    override fun createIntent(context: Context, input: Int): Intent {
        val intent = Intent(context, ThirdActivity::class.java)
        intent.putExtra(INPUT_KEY, input)
        Log.i("ksvlog", "\"createIntent\" putExtra: $input")
        return  intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        Log.i("ksvlog", "\"parseResult\" resultCode: $resultCode")
        if (resultCode != Activity.RESULT_OK) return "Result code not OK"


        if (intent == null) {
            Log.i("ksvlog", "\"parseResult\" Intent is null")
            return "Intent is null"
        }

        return intent.getStringExtra(OUT_KEY) ?: return "getExtra is null"
    }

    companion object {
        const val INPUT_KEY = "input_key"
        const val OUT_KEY = "out_key"
    }
}