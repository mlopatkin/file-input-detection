import java.io.FileInputStream

fun supported() {
    Utils.printAndClose("inputKotlin1.txt", FileInputStream(file("inputKotlin1.txt")))
    FileInputStream(file("inputKotlin2.txt").path).use {
        Utils.print("inputKotlin2.txt", it)
    }

    Utils.printAndClose("inputKotlin3.txt", file("inputKotlin3.txt").inputStream())
    Utils.printAndClose("inputKotlin4.txt", file("inputKotlin4.txt").reader())
    Utils.printAndClose("inputKotlin5.txt", file("inputKotlin5.txt").bufferedReader())
}

fun unsupported() {
    println(file("../undetected.txt").readText())
}

supported()
unsupported()