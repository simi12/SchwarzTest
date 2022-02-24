# SchwarzTest
## Assumptions about Project
1. If duplicates are present for given string same will be considered as Anagram and value will be printed in output.
2. Java Compiler 1.8
3. File contains only alphabets in lower case
4. Each line ends with valid teminator(new line feed or carraige return)

## Design details
Refer PDF file- ang.drawio.pdf

## How to run
1. Open Git bash to folder where you want this project
2. On terminal run command ::
    _git clone https://github.com/simi12/SchwarzTest.git_
3. Once repo is copied, Open the Java/Eclipse based IDE
4. Open **SchwarzAnagramProblemMaven** project in  IDE (Project is generated in Spring tool suite - version:4.12.1.Release)
5. Run AnagramFinder as Java application.
6. AnagramThreadBasedFinder is small independent utility to execute same problem with threads

## Input File
Stored in /src/resources/anagramListInputFile.txt
### Sample
act
cat
tree
race
care
acre
bee

## Expected Output
Following Output will be printed in console::
act cat
race care acre

