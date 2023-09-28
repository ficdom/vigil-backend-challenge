# backend-challenge

- Problem description: [link](https://github.com/VigilTech/backend-challenge)
- Scala solution: [link](src/main/scala/dfic/backendchallenge/TextFormatter.scala)
- Sample unit test: [link](src/test/scala/dfic/backendchallenge/TextFormatterSpec.scala). To execute it, run `sbt test` command (requires JDK, SBT & Scala installation).

Assumptions made to keep the solution simple:
- input text is small enough to fit in memory
- white space characters types don't need to be preserved and call all be replaced with space character (\x20)
