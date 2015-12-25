package kebab.junit4

import kebab.Browser
import kebab.Configuration
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit
import kotlin.collections.forEach

class KebabTest {

  init {
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe")
  }

  val config: Configuration by lazy {
    Configuration("http://www.google.co.jp/", ChromeDriver()) {
      timeout {
        implicitlyWait = 10L to TimeUnit.SECONDS
      }
    }
  }

  val browser: Browser by lazy {
    Browser(config)
  }

  @After
  fun teardown() {
    config.driver.quit()
  }

  @Test
  fun test() {
    browser.drive("http://www.google.co.jp/", {
      // 画面が表示されていること
      assertEquals("Google", title)

      find(By.tagName("input")).forEach { println("it = ${it}") }

      // TODO ここらへん出来てない
      // find(By.tagName("fugafuga")).getAttribute("hogehoge")
      // 検索ボタンを押下
      // val searchButton = find(By.cssSelector(".jsb > center:nth-child(1) > input:nth-child(1)"))
      // 検索を実行する
      // searchButton.click()
    })
    browser.quit()
  }
}
