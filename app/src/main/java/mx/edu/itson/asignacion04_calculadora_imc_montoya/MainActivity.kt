package mx.edu.itson.asignacion04_calculadora_imc_montoya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.weight) as EditText
        val height: EditText = findViewById(R.id.height) as EditText
        val btnCalcular: Button = findViewById(R.id.calcularIMC) as Button
        val IMC: TextView  = findViewById(R.id.txtIMC) as TextView
        val status: TextView = findViewById(R.id.txtStatus) as TextView


        btnCalcular.setOnClickListener {

            if(!weight.text.isBlank() && !height.text.isBlank()) {
                var imc = calcularIMC(height.text.toString().toDouble(), weight.text.toString().toDouble())
                val cat = categoria(imc)
                IMC.setText("" + Math.round(imc * 1000.000 / 1000.000) + "%")
                status.setText(cat)
            }
        }
    }

    fun calcularIMC(height: Double, weight: Double): Double{
        val imc = weight / (Math.pow(height, 2.0))
        return imc
    }

    fun categoria(IMC: Double): String
    {
        when{
            IMC < 18.5  -> return "Bajo peso"
            IMC < 25    -> return "Normal"
            IMC < 30    -> return "Sobrepeso"
            IMC < 35    -> return "Sobrepeso grado 1"
            IMC < 40    -> return "Sobrepeso grado 2"
            else        -> return "Sobrepeso grado 3"
        }
    }

}