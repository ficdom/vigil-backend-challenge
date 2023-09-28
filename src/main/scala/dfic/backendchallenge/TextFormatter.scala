package dfic.backendchallenge

object TextFormatter {

  def format(inputText: String, characterLimitPerLine: Int): String = {
    def splitText(formattedText: String, wordsToFormat: List[String], formattedLine: String): String =
      wordsToFormat match {
        case Nil => formattedText + formattedLine
        case currentWord :: remainingWords =>
          val (newFormattedText, newFormattedLine) =
            if (formattedLine.length + currentWord.length < characterLimitPerLine)
              (formattedText, if (formattedLine.isEmpty) currentWord else s"$formattedLine $currentWord")
            else
              (s"$formattedText$formattedLine\n", currentWord)
          splitText(newFormattedText, remainingWords, newFormattedLine)

      }

    val words = inputText.split("\\s+")

    splitText("", words.tail.toList, words.head)
  }

}
