package re.etienne.projet1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation des vues
        val btR1 = findViewById<Button>(R.id.btR1)
        val btR2 = findViewById<Button>(R.id.btR2)
        val btR3 = findViewById<Button>(R.id.btR3)
        val btR4 = findViewById<Button>(R.id.btR4)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvCpt = findViewById<TextView>(R.id.tvCpt)

        //Modification texte
        tvCpt.text = "1" //1.toString()
        tvQuestion.text = "Quelle est la couleur du cheval blanc d'Henri IV ?"
        btR1.text = "Bleu"
        btR2.text = "Blanc"
        btR3.text = "Rouge"
        btR4.text = "Noir"


        //Intent
        val intent = Intent(this,MainActivity2::class.java)

        //Function affichant un toast et demarrant la prochaine activite
        fun toastintent(reponse: Boolean){
            if(reponse){
                Toast.makeText(this,
                    "Bonne reponse", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,
                    "Mauvaise reponse", Toast.LENGTH_SHORT).show()
            }
            startActivity(intent)
        }

        //Button listener
        btR1.setOnClickListener { toastintent(false)}
        btR2.setOnClickListener { toastintent(true)}
        btR3.setOnClickListener { toastintent(false)}
        btR4.setOnClickListener { toastintent(false)}

    }
}