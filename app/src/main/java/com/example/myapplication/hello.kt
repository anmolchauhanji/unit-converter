import android.annotation.SuppressLint

@SuppressLint("SuspiciousIndentation")
fun main () {
    while (true) {
        val usr1 = readln()
        print("$usr1 \n")
        val usr2 = readln()


            print(usr2)
                if (usr1 == "rock" && usr2 == "paper" || usr1 == "paper" && usr2 == "scissor" || usr1 == "scissor" && usr2 == "rock") {
                print("usr2 win")
            } else if (usr2 == "rock" && usr1 == "paper" || usr2 == "paper" && usr1 == "scissor" || usr2 == "scissor" && usr1 == "rock") {
            print("usr1 win")

        }

        val again = readln()
        if (again != "yes") {
            print("thanks for playing")
            break
        }
    }
}

class dog {
    init {
        bark()
    }
    fun bark(){
        print("woof")
    }
}