package re.etienne.projet1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btR1 = findViewById<Button>(R.id.btR1)
        val btR2 = findViewById<Button>(R.id.btR2)
        val btR3 = findViewById<Button>(R.id.btR3)
        val btR4 = findViewById<Button>(R.id.btR4)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvCpt = findViewById<TextView>(R.id.tvCpt)

        tvCpt.text = "1" //1.toString()
        tvQuestion.text = "Quelle est la meilleur équipe de foot française ?"
        btR1.text = "Jeanne D'arc"
        btR2.text = "OM"
        btR3.text = "Saint Louisienne"
        btR4.text = "La tamponnaise"

        val toastMauvaiseReponse = Toast.makeText(this,
                "Mauvaise reponse", Toast.LENGTH_SHORT)
        val toastBonneReponse = Toast.makeText(this,
                "Bonne reponse", Toast.LENGTH_SHORT)

        btR1.setOnClickListener { toastMauvaiseReponse.show() }
        btR2.setOnClickListener { toastBonneReponse.show() }
        btR3.setOnClickListener { toastMauvaiseReponse.show() }
        btR4.setOnClickListener { toastMauvaiseReponse.show() }
    }
}