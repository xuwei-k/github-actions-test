object Main {
  def main(args: Array[String]): Unit = {
    val f = new java.io.File(sys.env("GITHUB_STEP_SUMMARY"))
    println(f.isFile)
    java.nio.file.Files.writeString(f.toPath, "aaa")
  }
}
