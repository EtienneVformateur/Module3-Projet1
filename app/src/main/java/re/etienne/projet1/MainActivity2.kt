package re.etienne.projet1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
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
        var cpt = intent.getIntExtra("Cpt_bonnereponse",0)
        tvCpt.text = cpt.toString() //2.toString()
        tvQuestion.text = "Quelle est la meilleur équipe de foot française ?"
        btR1.text = "Jeanne D'arc"
        btR2.text = "OM"
        btR3.text = "Saint Louisienne"
        btR4.text = "La tamponnaise"

        //Intent
        val Myintent = Intent(this,MainActivity::class.java)
        
        //Alerte
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Merci ! ")
        builder.setCancelable(false) // Oblige le clique sur un bouton 
        builder.setPositiveButton("Oui") { dialog, which ->
            startActivity(Myintent)
        }

        //Function affichant un toast et demarrant la prochaine activite
        fun alertintent(reponse: Boolean){

            if(reponse){
                cpt ++
                builder.setMessage("Super! Bonne réponse ! Vous avez eu $cpt bonnes réponses ! Rejouer ?")
                builder.show()
            }
            else{
                builder.setMessage("Mince! Vous avez eu $cpt bonnes réponses ! Mauvaise réponse ! Rééssayer ?")
                builder.show()
            }
        }

        //Button listener
        btR1.setOnClickListener { alertintent(false)}
        btR2.setOnClickListener { alertintent(true)}
        btR3.setOnClickListener { alertintent(false)}
        btR4.setOnClickListener { alertintent(false)}
    }
}