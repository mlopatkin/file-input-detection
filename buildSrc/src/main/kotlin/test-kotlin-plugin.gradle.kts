import java.io.FileInputStream

fun supported() {
    Utils.printAndClose("inputKotlinPlugin1.txt", FileInputStream(file("inputKotlinPlugin1.txt")))
    FileInputStream(file("inputKotlinPlugin2.txt").path).use {
        Utils.print("inputKotlinPlugin2.txt", it)
    }

    Utils.printAndClose("inputKotlinPlugin3.txt", file("inputKotlinPlugin3.txt").inputStream())
    Utils.printAndClose("inputKotlinPlugin4.txt", file("inputKotlinPlugin4.txt").reader())
    Utils.printAndClose("inputKotlinPlugin5.txt", file("inputKotlinPlugin5.txt").bufferedReader())
}

fun unsupported() {
    println(file("undetected.txt").readText())
}

supported()
unsupported()