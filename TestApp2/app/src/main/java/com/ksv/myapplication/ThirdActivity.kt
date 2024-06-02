package com.ksv.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.ksv.myapplication.activityresult.ExerciseType
import com.ksv.myapplication.databinding.ActivityThirdBinding
import com.ksv.myapplication.activityresult.InputClass
import com.ksv.myapplication.activityresult.MyIntRange
import com.ksv.myapplication.activityresult.OutClass
import com.ksv.myapplication.activityresult.ThirdActivityContractCustom
import com.ksv.myapplication.activityresult.ThirdActivityContractSimple

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // with simple types
//        val input = intent.getIntExtra(ThirdActivityContractSimple.INPUT_KEY, -1)
//        binding.tvInput.text = input.toString()

        // with custom types
        try {
            val input =
                intent.getSerializableExtra(ThirdActivityContractCustom.INPUT_KEY) as InputClass
                //intent.getSerializableExtra(ThirdActivityContractCustom.INPUT_KEY, InputClass::class.java)

            val txt = if(input != null) "${input.data}, ${input.msg}, ${input.flag}" else "null"
            binding.tvInput.text = txt

        }catch (except: ClassCastException){
            binding.tvInput.text = except.toString()
        }catch (except: Exception){
            binding.tvInput.text = except.toString()
        }

        //val inp = intent.getSerializableExtra(ThirdActivityContractCustom.INPUT_KEY, InputClass::class.java)

    }

    fun onClickBack(view: View){
        // with simple types (String)
//        intent = Intent()
//        val outValue = binding.etOut.text.toString()
//        intent.putExtra(ThirdActivityContractSimple.OUT_KEY, outValue)
//        setResult(Activity.RESULT_OK, intent)
//        finish()

        // with custom types
        intent = Intent()
        //val outValue = OutClass(binding.etOut.text.toString(), (0..99).random())
//        val outValue = OutClass(binding.etOut.text.toString(), (0..99).random(), ExerciseType.DIVISION, IntRange(10,20), IntRange(20,30))
        val outValue = OutClass(binding.etOut.text.toString(), (0..99).random(), ExerciseType.DIVISION, MyIntRange(10, 50))
        intent.putExtra(ThirdActivityContractCustom.OUT_KEY, outValue)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}