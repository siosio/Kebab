package kebab.junit4

import kebab.Browser
import kebab.Configuration
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class KebabTest {
    lateinit var config: Configuration
    lateinit var browser: Browser

    @Before
    fun setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver")
        config = Configuration("http://www.google.co.jp/", ChromeDriver())
        config.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        browser = Browser(config)
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
