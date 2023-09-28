package dfic.backendchallenge

import scala.annotation.tailrec

object TextFormatter {

  def format(inputText: String, characterLimitPerLine: Int): String = {

    @tailrec
    def splitText(formattedText: String, wordsToFormat: List[String], currentLine: String): String =
      wordsToFormat match {
        case Nil => formattedText + currentLine
        case currentWord :: remainingWords =>
          val (newFormattedText, newFormattedLine) =
            if (currentLine.length + currentWord.length < characterLimitPerLine) {
              // adding new word to current line as number of characters is still within the limit
              (formattedText, if (currentLine.isEmpty) currentWord else s"$currentLine $currentWord")
            } else {
              // formatting of the current line is done, adding it to the formatted text
              (s"$formattedText$currentLine\n", currentWord)
            }
          splitText(newFormattedText, remainingWords, newFormattedLine)
      }

    val words = inputText.split("\\s+")

    splitText("", words.tail.toList, words.head)
  }
}
