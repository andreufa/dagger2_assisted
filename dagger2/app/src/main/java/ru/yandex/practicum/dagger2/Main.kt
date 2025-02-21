package ru.yandex.practicum.dagger2

fun main() {
    val shifr = """F2p)v"y233{0->c}ttelciFc"""
    val symbol1 = shifr.substring(0, shifr.length - 12)
    val symbol2 = shifr.substring (startIndex= shifr. length -12)
    val result2 = decoding(symbol2).toString()
    println(result2)
}
fun decoding (symbol1:String): String{
    val shiftedString1 = symbol1.map { char-> char + 1}.joinToString (separator="")
    val  code1 = shiftedString1.replace(oldChar='s',newChar='5')
    val  code2 = code1.replace(oldChar='u',newChar='4')
    val  code3 = code2.map {char->char-3}.joinToString(separator="")
    val  code4 = code3.replace(oldChar='0',newChar='0')
    return code4
}
fun decoding2 (symbol2: String): String{
    val  reversed = symbol2.reversed()
    val  shiftedString2 = reversed.map { char->char-4}.joinToString(separator="" )
    val  code5 = shiftedString2.replace(oldChar= '_',newChar='_')
    return code5
}

