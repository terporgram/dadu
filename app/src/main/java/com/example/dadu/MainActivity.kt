package com.example.dadu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // do A dice roll when the app starts
        rollDice()
    }

    /**
     * roll teh dice and update the screen with the reslt.
     */
    private fun rollDice() {
        // create new dice object with 6 sides adn roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)


        // kode ringkas nya
        // determine which drawable resource ID to use based on the dice roll
        val drawableResouce = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }



        // update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResouce)

        // update the content description
        diceImage.contentDescription = diceRoll.toString()

//        kode agak ribet
//        val diceImage: ImageView = findViewById(R.id.imageView)
//        when (diceRoll){
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }


//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
    }
}

class Dice(val numSides: Int){
    fun roll() : Int {
        return (1..numSides).random()
    }
}