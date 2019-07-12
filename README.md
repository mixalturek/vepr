Vepř
====

*Yet another [pig-latin][wikipedia] translation tool.*


Motivation
----------

A task to show Java coding skills, nothing more...


Task description
----------------

Write some Java code that translates a string (word, sentence, or paragraph) into "pig-latin" using the following rules.

- Words that start with a consonant have their first letter moved to the end of the word and the letters "ay" added to the end.
    - **Hello** becomes **Ellohay**
- Words that start with a vowel have the letters "way" added to the end.
    - **apple** becomes **appleway**
- Words that end in "way" are not modified.
    - **stairway** stays as **stairway**
- Punctuation must remain in the same relative place from the end of the word.
    - **can't** becomes **antca'y**
    - **end.** becomes **endway.**
- Hyphens are treated as two words
    - **this-thing** becomes **histay-hingtay**
- Capitalization must remain in the same place.
    - **Beach** becomes **Eachbay**
    - **McCloud** becomes **CcLoudmay**


Usage
-----

Class `com.github.mixalturek.vepr.VeprPipe` is a *unix pipe* that reads lines from standard input and produces
their translations to the standard output.

```
[m@evm vepr]$ ./gradlew clean build

BUILD SUCCESSFUL in 1s
8 actionable tasks: 8 executed
[m@evm vepr]$
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
You have an unusual equipment for success.  Be sure to use it properly.
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Ouyay avehay anway unusualway equipmentway orfay uccesssay.  EBay uresay otay useway itway roperlypay.
[m@evm vepr]$ 
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
Q:      How many Harvard MBA's does it take to screw in a light bulb?
A:      Just one.  He grasps it firmly and the universe revolves around him.
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Qay:    Owhay anymay Arvardhay BASMa'y oesday itway aketay otay crewsay inway away ightlay ulbbay?
Away:   Ustjay oneway.  EHay raspsgay itway irmlyfay andway hetay universeway evolvesray aroundway imhay.
[m@evm vepr]$ 
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
A classic is something that everyone wants to have read
and nobody wants to read.
                -- Mark Twain, "The Disappearance of Literature"
[m@evm vepr]$
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Away lassiccay isway omethingsay hattay everyoneway antsway otay avehay eadray
andway obodynay antsway otay eadray.
                -- Arkmay Waintay, "Hetay Isappearanceday ofway Iteraturelay"
[m@evm vepr]$ 
```


[wikipedia]: https://en.wikipedia.org/wiki/Pig_Latin
