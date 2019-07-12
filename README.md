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
their translations to the standard output. Execute `./gradlew clean build` to compile the code.

```
[m@evm vepr]$ echo 'Hello, world!' | java -jar vepr/build/libs/vepr.jar
Ellohay, orldway!
[m@evm vepr]$ 
```

```
[m@evm vepr]$ java -jar vepr/build/libs/vepr.jar
Hi, there!
Ihay, heretay!
Bye...
Yebay...
[m@evm vepr]$
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
Long life is in store for you.
[m@evm vepr]$
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Onglay ifelay isway inway toresay orfay ouyay.
[m@evm vepr]$ 
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
If you can read this, you're too close.
[m@evm vepr]$
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Ifway ouyay ancay eadray histay, ourey'ay ootay losecay.
[m@evm vepr]$ 
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
Q:      How many Harvard MBA's does it take to screw in a light bulb?
A:      Just one.  He grasps it firmly and the universe revolves around him.
[m@evm vepr]$
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Qay:    Owhay anymay Arvardhay BASma'y oesday itway aketay otay crewsay inway away ightlay ulbbay?
Away:   Ustjay oneway.  Ehay raspsgay itway irmlyfay andway hetay universeway evolvesray aroundway imhay.
[m@evm vepr]$
```

```
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
[m@evm vepr]$ TEXT="$(fortune)" && echo "${TEXT}"
The first thing we do, let's kill all the lawyers.
                -- Wm. Shakespeare, "Henry VI", Part IV
[m@evm vepr]$
[m@evm vepr]$ echo "${TEXT}" | java -jar vepr/build/libs/vepr.jar
Hetay irstfay hingtay eway oday, etsla'y illkay allway hetay awyerslay.
                -- Mway. Hakespearesay, "Enryhay IVay", Artpay IVway
[m@evm vepr]$
```


[wikipedia]: https://en.wikipedia.org/wiki/Pig_Latin
