package re.etienne.projet1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import re.etienne.projet1.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    class Question(
        val Enonce: String,
        val Reponse: Array<String>,
        var bonnereponse: Int,
    )

    var cpt = 0

    val q1 = Question(Enonce = "Quelle est la couleur du cheval blanc ?", Reponse = arrayOf("Bleu","Blanc","Rouge","Rose"), bonnereponse = 1)
    val q2 = Question(Enonce = "Quelle est la couleur du cheval bleu ?", Reponse = arrayOf("Bleu","Blanc","Rouge","Rose"), bonnereponse = 0)
    val q3 = Question(Enonce = "Quelle est la couleur du cheval rouge ?", Reponse = arrayOf("Bleu","Blanc","Rouge","Rose"), bonnereponse = 2)
    val listQuestion = arrayOf(q1,q2,q3)
    var q_encours = 0

    fun toastcpt(reponse: Boolean){
        if(reponse){
            Toast.makeText(this,
                "Bonne reponse", Toast.LENGTH_SHORT).show()
            cpt ++
            binding.tvCpt.text = cpt.toString()
        }
        else{
            Toast.makeText(this,
                "Mauvaise reponse", Toast.LENGTH_SHORT).show()
        }
        q_encours ++
        if (q_encours<listQuestion.size)
        {
            chargeQuestion(listQuestion[q_encours])
        }
        else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Rejouer ? ! ")
            builder.setCancelable(false) // Oblige le clique sur un bouton
            builder.setPositiveButton("Oui") { dialog, which ->
                q_encours = 0
                cpt = 0
                chargeQuestion(listQuestion[q_encours])
            }
            builder.show()
        }
    }

    fun chargeQuestion(q:Question){
        binding.tvQuestion.text = q.Enonce
        binding.btR1.text = q.Reponse[0]
        binding.btR2.text = q.Reponse[1]
        binding.btR3.text = q.Reponse[2]
        binding.btR4.text = q.Reponse[3]

        binding.btR1.setOnClickListener { toastcpt(binding.btR1.text == q.Reponse[q.bonnereponse] ) }
        binding.btR2.setOnClickListener { toastcpt(binding.btR2.text == q.Reponse[q.bonnereponse] ) }
        binding.btR3.setOnClickListener { toastcpt(binding.btR3.text == q.Reponse[q.bonnereponse] ) }
        binding.btR4.setOnClickListener { toastcpt(binding.btR4.text == q.Reponse[q.bonnereponse] ) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btversion.text  = "Version 1"
        binding.btversion.setOnClickListener {
            val intentActivity1 = Intent(this,MainActivity::class.java)
            startActivity(intentActivity1)
        }

        chargeQuestion(listQuestion[q_encours])



    }
}