package foo

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.play.OneBrowserPerSuite
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

class Test1 extends AnyWordSpec with GuiceOneServerPerSuite with OneBrowserPerSuite {

  "views" must {
    s"titleが読み込める" in {
      val path = controllers.routes.HomeController.index().path()
      go to s"http://127.0.0.1:$port$path"

      val title = implicitly[WebDriver].getTitle
      assert(title == "hello", title)
    }
  }

  override def createWebDriver(): WebDriver = {
    val options = new ChromeOptions()
    options.addArguments("--headless=new")
    new ChromeDriver(options)
  }
}
