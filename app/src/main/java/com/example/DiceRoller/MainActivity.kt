package com.example.DiceRoller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Defining my buttons
        val firstRollButton: Button = findViewById(R.id.button)
        val secondRollButton: Button = findViewById(R.id.button2)

        // Buttons Listeners
        firstRollButton.setOnClickListener{rollDice(findViewById(R.id.imageView))}
        secondRollButton.setOnClickListener{rollDice(findViewById(R.id.imageView2))}

        // Initial roll
        rollDice(findViewById(R.id.imageView2))
        rollDice(findViewById(R.id.imageView))
    }

    private fun rollDice(diceImage: ImageView) {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Getting a variable resource ID
        val drawableResourceId : Int = this.resources.getIdentifier("dice_$diceRoll", "drawable", this.packageName)

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResourceId)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}
