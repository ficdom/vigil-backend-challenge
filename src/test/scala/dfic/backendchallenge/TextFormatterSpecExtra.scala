package dfic.backendchallenge

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TextFormatterSpecExtra extends AnyFlatSpec with Matchers {

  "it" should "handle empty input" in {
    val inputText     = ""
    val formattedText = TextFormatter.format(inputText, 40)
    formattedText shouldBe ""
  }

  it should "handle a single word longer than the limit" in {
    val inputText     = "Supercalifragilisticexpialidocious"
    val formattedText = TextFormatter.format(inputText, 20)
    formattedText shouldBe "Supercalifragilisticexpialidocious"
  }

  it should "handle a single word exactly at the limit" in {
    val inputText     = "Hello"
    val formattedText = TextFormatter.format(inputText, 5)
    formattedText shouldBe "Hello"
  }

  it should "handle long words in the middle of a sentence" in {
    val inputText     = "This is a supercalifragilisticexpialidocious test."
    val formattedText = TextFormatter.format(inputText, 20)
    formattedText shouldBe "This is a\nsupercalifragilisticexpialidocious\ntest."
  }

  it should "preserve lines already within the limit" in {
    val inputText     = "This is a test.\nAnother line."
    val formattedText = TextFormatter.format(inputText, 20)
    formattedText shouldBe "This is a test.\nAnother line."
  }

  it should "handle a long paragraph" in {
    val inputText =
      "This is a long paragraph that needs to be split into multiple lines because it exceeds the character limit.\n" +
        "Each line should not exceed the specified limit, and words should not be broken."

    val formattedText = TextFormatter.format(inputText, 40)
    val expectedOutput =
      "This is a long paragraph that needs to\n" +
        "be split into multiple lines because it\n" +
        "exceeds the character limit. Each line\n" +
        "should not exceed the specified limit,\n" +
        "and words should not be broken."

    formattedText shouldBe expectedOutput
  }

  it should "handle punctuation correctly" in {
    val inputText     = "This, is a test.\nAnother line; yet another line."
    val formattedText = TextFormatter.format(inputText, 20)
    val expectedOutput =
      "This, is a test.\n" +
        "Another line; yet\n" +
        "another line."

    formattedText shouldBe expectedOutput
  }

  it should "handle different character limit values" in {
    val inputText      = "This is a test of different character limits."
    val formattedText1 = TextFormatter.format(inputText, 15)
    val formattedText2 = TextFormatter.format(inputText, 30)

    val expectedOutput1 =
      "This is a test\n" +
        "of different\n" +
        "character\n" +
        "limits."

    val expectedOutput2 =
      "This is a test of different\n" +
        "character limits."

    formattedText1 shouldBe expectedOutput1
    formattedText2 shouldBe expectedOutput2
  }

  it should "handle lines ending with punctuation" in {
    val inputText     = "This is a test.\nAnother line."
    val formattedText = TextFormatter.format(inputText, 20)
    val expectedOutput =
      "This is a test.\n" +
        "Another line."

    formattedText shouldBe expectedOutput
  }

  it should "handle mixed whitespace" in {
    val inputText     = "This\tis  a  test."
    val formattedText = TextFormatter.format(inputText, 20)
    val expectedOutput =
      "This is a test."

    formattedText shouldBe expectedOutput
  }

  it should "handle very long input text" in {
    // Create a very long input text with no word breaks to test performance
    val inputText     = "Lorem ipsum dolor sit amet, " * 1000
    val formattedText = TextFormatter.format(inputText, 40)
    val expectedOutput = (List
      .fill(142)(
        List(
          "Lorem ipsum dolor sit amet, Lorem ipsum",
          "dolor sit amet, Lorem ipsum dolor sit",
          "amet, Lorem ipsum dolor sit amet, Lorem",
          "ipsum dolor sit amet, Lorem ipsum dolor",
          "sit amet, Lorem ipsum dolor sit amet,"
        )
      )
      .flatten ++ List(
      "Lorem ipsum dolor sit amet, Lorem ipsum",
      "dolor sit amet, Lorem ipsum dolor sit",
      "amet, Lorem ipsum dolor sit amet, Lorem",
      "ipsum dolor sit amet, Lorem ipsum dolor",
      "sit amet,"
    )).mkString("\n")
    formattedText shouldBe expectedOutput
  }

  //  it should "handle lines containing only whitespace" in {
  //    val inputText = List("   ", "\t\t\t", "      ")
  //    val formattedText = TextFormatter.format(inputText, 20)
  //    formattedText shouldBe inputText
  //  }

  //  it should "handle lines with different whitespace characters" in {
  //    val inputText = List("This is a test.", "Another\tline.", "Yet  another line.")
  //    val formattedText = TextFormatter.format(inputText, 20)
  //    formattedText shouldBe List(
  //      "This is a test.",
  //      "Another\tline.",
  //      "Yet  another line."
  //    )
  //  }

  it should "handle lines ending with multiple punctuation marks" in {
    val inputText     = "This is a test!!!\nAnother line???\nYet another line."
    val formattedText = TextFormatter.format(inputText, 20)
    val expectedOutput =
      "This is a test!!!\n" +
        "Another line??? Yet\n" +
        "another line."

    formattedText shouldBe expectedOutput
  }

  //  it should "handle randomized input text" in {
  //    // Generate random input text for testing
  //    val inputText = List(
  //      "This is a test sentence.",
  //      "Another random line with punctuation???",
  //      "Short line.",
  //      "A\ttab\ttest.",
  //      "Line with special characters: é, ö, ñ.",
  //      "This is a URL: https://example.com",
  //      "Email: test@example.com",
  //      "HTML tags <b>should</b> not be split.",
  //      "Very long line that should be broken into multiple lines because it exceeds the character limit.",
  //      "A.",
  //      "   ",
  //      "  Leading whitespace line."
  //    )
  //
  //    val formattedText = TextFormatter.format(inputText, 30)
  //
  //    // Verify that the formatted text matches the expected number of lines
  //    // (This assumes that the expected output is manually verified)
  //    formattedText.size shouldEqual inputText.size
  //  }

  it should "handle large random input text" in {
    // Generate a large random input text for testing (e.g., thousands of lines)
    val inputText = (1 to 1000).map { i =>
      s"This is line $i of the large random input text."
    }.mkString("\n")

    val formattedText = TextFormatter.format(inputText, 50)

    // Verify that the formatted text matches the expected number of lines
    // (This assumes that the expected output is manually verified)
    val expectedOutput = inputText.split("\n").map(_.take(50)).mkString("\n")
    formattedText shouldBe expectedOutput
  }
}
