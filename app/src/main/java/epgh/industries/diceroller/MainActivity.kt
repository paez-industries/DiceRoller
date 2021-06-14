package epgh.industries.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// La clase MainActivity es creada por defecto
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // asigna el elemento Button a rollButton buscandolo dentro de las vistas
        val rollButton: Button = findViewById(R.id.button)

        // funcion de escucha a la espera de que el elemento Button sea accionado
        rollButton.setOnClickListener { rollDice() }

        // primer lanzamiento del dado
        rollDice()
    }

    // La funcion crea un objeto de la clase Dice o dado y le asigna parametros
    private fun rollDice() {
        // para el primer dado
        val diceImage1: ImageView = findViewById(R.id.image_1)
        val dado1 = Dice(6)
        val diceRoll1 = dado1.roll()
        // se encargan de escoger las imagenes adecuadas en cada lanzamiento
        when (diceRoll1) {
            1 -> diceImage1.setImageResource(R.drawable.dice_1)
            2 -> diceImage1.setImageResource(R.drawable.dice_2)
            3 -> diceImage1.setImageResource(R.drawable.dice_3)
            4 -> diceImage1.setImageResource(R.drawable.dice_4)
            5 -> diceImage1.setImageResource(R.drawable.dice_5)
            6 -> diceImage1.setImageResource(R.drawable.dice_6)
        }
        // para el segundo dado
        val diceImage2: ImageView = findViewById(R.id.image_2)
        val dado2 = Dice(6)
        val diceRoll2 = dado2.roll()
        // se encargan de escoger las imagenes adecuadas en cada lanzamiento
        when (diceRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }
        // Para el texto de Valeria y Valentina
        val valeria = "Valeria"
        val valentina = "valentina"
        val texto: TextView = findViewById(R.id.text_1)
        if (diceRoll1 >= diceRoll2){
            texto.text = valeria
        }else{
            texto.text = valentina
        }

    }
}

// la clase dice definen el objeto dado con sus metodos y atributos
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
