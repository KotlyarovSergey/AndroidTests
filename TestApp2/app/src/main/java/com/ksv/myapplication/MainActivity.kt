package com.ksv.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import com.ksv.myapplication.databinding.ActivityMainBinding
import com.ksv.myapplication.activityresult.InputClass
import com.ksv.myapplication.activityresult.MyIntRange
import com.ksv.myapplication.activityresult.ThirdActivityContractCustom
import com.ksv.myapplication.activityresult.ThirdActivityContractSimple

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityLauncherSimple: ActivityResultLauncher<Int>
    private lateinit var activityLauncherCustom: ActivityResultLauncher<InputClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btOk.setOnClickListener {
            binding.tvTitle.text = getString(R.string.hellomessage)
        }

        binding.btSecondActivity.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        activityLauncherSimple = registerForActivityResult(ThirdActivityContractSimple()){
            val answ = it ?: "answer is null"
            binding.etAnswer.setText(answ)

        }

        activityLauncherCustom = registerForActivityResult(ThirdActivityContractCustom()){
            if(it == null)
                binding.etAnswer.setText("answer is Null")
            else{
//                val txt = "answ: ${it.answer}, code: ${it.code}"
//                binding.etAnswer.setText(txt)
                val extend = "Ex: ${it.exerciseType.name}, [${it.firstRange.first}, ${it.firstRange.last}].rnd = ${it.firstRange.random()}"
                binding.etAnswer.setText(extend)
            }
        }

    }

    fun onClickThirdActivity(view: View){
        // without Activity Result Api
//        intent = Intent(this, ThirdActivity::class.java)
//        val range = IntRange(10, 20)
//        //intent.putExtra("OUT_VALUE", range)
//        startActivity(intent)

        // with Simple types
//        val i = binding.etSend.text.toString().toIntOrNull()
//        val inputValue = i ?: 6543513
//        Log.i("ksvlog", "\"onClickThirdActivity\" inputValue: $inputValue")
//        activityLauncherSimple.launch(inputValue)

        // with Custom types
        val s = binding.etSend.text.toString()
        val i = (0..100).random()
        val b = (i % 2 == 0)
        val inputClass = InputClass(i, s, b)
        Log.i("ksvlog", "\"onClickThirdActivity\"inputClass = [$i, $s, $b]")
        activityLauncherCustom.launch(inputClass)

    }

    fun onClickSharPrefActivity(view: View){
        intent = Intent(this, SharedPreferencesActivity::class.java)
        startActivity(intent)
    }

    fun onClickRecyclerViewActivity(view: View){
        intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }
}