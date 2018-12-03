fun main(args : Array<String>) {

    var helloStr : String
    if(args.isEmpty()) {
        helloStr = getHelloString()
    } else {
        helloStr = args[0];
    }
    println("Hello " + helloStr)
}


fun getHelloString() : String {
    return "World!"
}


