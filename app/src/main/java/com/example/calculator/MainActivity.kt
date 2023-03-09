package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.btn0.setOnClickListener{
            setTextFields("0")
        }
        bindingClass.btn1.setOnClickListener{
            setTextFields("1")
        }
        bindingClass.btn2.setOnClickListener{
            setTextFields("2")
        }
        bindingClass.btn3.setOnClickListener{
            setTextFields("3")
        }
        bindingClass.btn4.setOnClickListener{
            setTextFields("4")
        }
        bindingClass.btn5.setOnClickListener{
            setTextFields("5")
        }
        bindingClass.btn6.setOnClickListener{
            setTextFields("6")
        }
        bindingClass.btn7.setOnClickListener{
            setTextFields("7")
        }
        bindingClass.btn8.setOnClickListener{
            setTextFields("8")
        }
        bindingClass.btn9.setOnClickListener{
            setTextFields("9")
        }
        bindingClass.minusBtn.setOnClickListener{
            setTextFields("-")
        }
        bindingClass.plusBtn.setOnClickListener{
            setTextFields("+")
        }
        bindingClass.multiplyBtn.setOnClickListener{
            setTextFields("*")
        }
        bindingClass.shareBtn.setOnClickListener{
            setTextFields("/")
        }
        bindingClass.leftS.setOnClickListener{
            setTextFields("(")
        }
        bindingClass.rightS.setOnClickListener{
            setTextFields(")")
        }
        bindingClass.dotBtn.setOnClickListener{
            setTextFields(".")
        }

        bindingClass.delBtn.setOnClickListener{
            bindingClass.mathOperation.text = ""
            bindingClass.resultText.text = ""
        }

        bindingClass.backBtn.setOnClickListener{
            val str = bindingClass.mathOperation.text.toString()
            if (str.isNotEmpty())
                bindingClass.mathOperation.text = str.substring(0, str.length-1)

            bindingClass.resultText.text = ""
        }

        bindingClass.equallyBtn.setOnClickListener{
            try {
                val ex = bindingClass.mathOperation.text.toString()
                val result = ExpressionBuilder(ex).build().evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    bindingClass.resultText.text = longRes.toString()
                else
                    bindingClass.resultText.text = result.toString()


            } catch(e:Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }


    }
    fun setTextFields(str: String){
        if (bindingClass.resultText.text != ""){
            bindingClass.mathOperation.text = bindingClass.resultText.text
            bindingClass.resultText.text = ""
        }
        bindingClass.mathOperation.append(str)

    }
}