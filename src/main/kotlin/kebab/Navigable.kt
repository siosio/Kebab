package kebab

import org.openqa.selenium.By

interface Navigable {
  fun find(): Navigator
  fun find(index: Int): Navigator
  fun find(range: ClosedRange<Int>): Navigator
  fun find(selector: String): Navigator
  fun find(selector: String, index: Int): Navigator
  fun find(selector: String, range: ClosedRange<Int>): Navigator
  fun find(attributes: MutableMap<String, Any>): Navigator
  fun find(attributes: MutableMap<String, Any>, index: Int): Navigator
  fun find(attributes: MutableMap<String, Any>, range: ClosedRange<Int>): Navigator
  fun find(attributes: MutableMap<String, Any>, selector: String): Navigator
  fun find(attributes: MutableMap<String, Any>, selector: String, index: Int): Navigator
  fun find(attributes: MutableMap<String, Any>, selector: String, range: ClosedRange<Int>): Navigator
  fun find(attributes: MutableMap<String, Any>, bySelector: By): Navigator
  fun find(attributes: MutableMap<String, Any>, bySelector: By, index: Int): Navigator
  fun find(attributes: MutableMap<String, Any>, bySelector: By, range: ClosedRange<Int>): Navigator
  fun find(bySelector: By): Navigator
  fun find(bySelector: By, index: Int): Navigator
  fun find(bySelector: By, range: ClosedRange<Int>): Navigator
}
