package hello

fun getHelloString() : String {
    return "Hello, world!"
}

fun main(args : Array<String>) {
    println(getHelloString())

    var r = khttp.get("http://www.google.co.uk")
    println(r.statusCode)
    println(r.headers["content-type"])
    println(r.text)
}

