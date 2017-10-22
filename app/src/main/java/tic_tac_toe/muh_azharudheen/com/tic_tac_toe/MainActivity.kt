package tic_tac_toe.muh_azharudheen.com.tic_tac_toe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view:View){
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

        //Toast.makeText(this, "ID:" + cellId , Toast.LENGTH_SHORT).show()
        playGame(cellId,buSelected)
    }

    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    var activePlayer = 1

    fun playGame(cellId: Int,  buSelected: Button){

        if (activePlayer == 1){
            player1.add(cellId)
            activePlayer = 2
            buSelected.text = "x"
            buSelected.setBackgroundColor(Color.GREEN)
        } else {
            player2.add(cellId)
            activePlayer = 1
            buSelected.text = "0"
            buSelected.setBackgroundColor(Color.BLUE)
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        } else if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }  else if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 1
        }  else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 1
        }

        if (winner == 1) {
            Toast.makeText(this,"Player 1 is the winner", Toast.LENGTH_SHORT).show()
        } else if (winner == 2) {
            Toast.makeText(this,"Player 2 is the winner", Toast.LENGTH_SHORT).show()
        } else {
//            Toast.makeText(this,"Continue  Playing", Toast.LENGTH_SHORT).show()
        }

    }
}
