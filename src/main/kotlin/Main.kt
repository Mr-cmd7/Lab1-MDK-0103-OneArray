import java.lang.StringBuilder
import kotlin.random.Random
fun main(){
    val lengtn = 7 //Задайте желаемую длину
    val binaryNumber = generateRandomBinaryNumber(lengtn)
    val shiftedBinaryNumber = shiftLeft(binaryNumber,2)

    val originalDecimal = binaryToDecimal(binaryNumber)
    val shiftedDecimal = binaryToDecimal(shiftedBinaryNumber)

    val difference = originalDecimal - shiftedDecimal

    println("Исходное двоичное число: " + binaryNumber)
    println("После циклического сдвига: " + shiftedBinaryNumber)
    println("Разность чисел: " + difference )

}
//Генератор бинарного числа
fun generateRandomBinaryNumber(lengtn : Int) : String{
    require(lengtn>0){"Длина должна быть больше 0"}

    val random = Random.Default
    val binaryNumber = StringBuilder()

    for (i in 0 until lengtn){
        val bit = random.nextInt(2)
        binaryNumber.append(bit)
    }
    return binaryNumber.toString()
}
//Функция для циклического сдвига влево
fun shiftLeft(binaryNumber: String,positions: Int):String{
    val lengtn = binaryNumber.length
    val shiftAmount = positions % lengtn
    return binaryNumber.substring(shiftAmount)+binaryNumber.substring(0,shiftAmount)
}
//Преображение из двоичной в десятичную
fun binaryToDecimal(binaryNumber: String):Int{
    return Integer.parseInt(binaryNumber,2)
}