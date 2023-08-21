package com.github.pdrdest.atividade21_08

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var inputWeight: EditText? = null
    private var resultText: TextView? = null
    private var radioGroup: RadioGroup? = null
    private var kgToLbRadio: RadioButton? = null
    private var lbToKgRadio: RadioButton? = null
    private var convertButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputWeight = findViewById(R.id.valor_numerico)
        resultText = findViewById(R.id.resultado_calculo)
        radioGroup = findViewById(R.id.opcoes_calcular)
        kgToLbRadio = findViewById(R.id.kg_lbs)
        lbToKgRadio = findViewById(R.id.lbs_kg)
        convertButton = findViewById(R.id.botao_calcular)
        convertButton.setOnClickListener(View.OnClickListener { convertWeight() })
    }

    private fun convertWeight() {
        val input = inputWeight!!.text.toString().trim { it <= ' ' }
        if (input.isEmpty()) {
            resultText!!.text = "Por favor digite o peso."
            return
        }
        val inputValue = input.toDouble()
        val result: Double
        if (kgToLbRadio!!.isChecked) {
            result = inputValue * 2.2
            resultText!!.text = "$inputValue kg = $result lb"
        } else if (lbToKgRadio!!.isChecked) {
            result = inputValue / 2.2
            resultText!!.text = "$inputValue lb = $result kg"
        } else {
            resultText!!.text = "Por favor selecione a opção de conversão."
        }
    }
}