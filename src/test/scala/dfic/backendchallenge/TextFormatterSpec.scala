import scala.io.Source

import dfic.backendchallenge.TextFormatter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TextFormatterSpec extends AnyFlatSpec with Matchers {

  "it" should "format text with character limit per line set to 40" in {
    val inputText      = Source.fromResource("sample_input.txt").getLines().mkString("\n")
    val expectedOutput = Source.fromResource("sample_output_40.txt").getLines().mkString("\n")

    val formattedText = TextFormatter.format(inputText, 40)
    formattedText shouldBe expectedOutput
  }
}
