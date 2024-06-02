package com.ksv.myapplication.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import com.ksv.myapplication.ThirdActivity

class ThirdActivityContractCustom: ActivityResultContract<InputClass, OutClass?>() {
    override fun createIntent(context: Context, input: InputClass): Intent {
        val intent = Intent(context, ThirdActivity::class.java)
        intent.putExtra(INPUT_KEY, input)
        Log.i("ksvlog", "\"createIntent\" putExtra: $input")
        return  intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): OutClass? {
        Log.i("ksvlog", "\"parseResult\" resultCode: $resultCode")
        if (resultCode != Activity.RESULT_OK) return null


        if (intent == null) {
            Log.i("ksvlog", "\"parseResult\" Intent is null")
            return null
        }

        val out = intent.getSerializableExtra(OUT_KEY) as OutClass
        if (out == null){
            Log.i("ksvlog", "Cast ot OutClass failed")
        }else{
            Log.i("ksvlog", "answer: [${out.answer}, ${out.code}")
        }
        return out
    }

    companion object {
        const val INPUT_KEY = "input_key_cstm"
        const val OUT_KEY = "out_key_cstm"

        enum class ExerciseType(val value: Int) {
            SUMMATION(0), SUBTRACTION(1), MULTIPLICATION(2), DIVISION(3)
        }
    }
}