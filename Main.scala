object Main {
  def main(args: Array[String]): Unit = {
    println(sys.env.get("GITHUB_STEP_SUMMARY"))
    sys.process.Process(Seq("/bin/bash", "echo foo >> $GITHUB_STEP_SUMMARY")).!
    println(sys.env.get("GITHUB_STEP_SUMMARY"))
  }
}
