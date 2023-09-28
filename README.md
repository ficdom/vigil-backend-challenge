# backend-challenge

- Problem description: [link](https://github.com/VigilTech/backend-challenge)
- Scala solution: [link](src/main/scala/dfic/backendchallenge/TextFormatter.scala)
- Sample unit test: [link](src/test/scala/dfic/backendchallenge/TextFormatterSpec.scala). To execute it, run `sbt test` command (requires JDK, SBT & Scala installation).

### Assumptions
To keep the solution simple, I've made the following assumptions:
- The input text is small enough to fit in memory.
- All whitespace characters types can be replaced with space characters (\x20) and don't need to be preserved.