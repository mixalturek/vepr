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

Class `com.github.mixalturek.vepr.Vepr` is a *unix pipe* that reads lines from standard input and produces
their translations to the standard output.



[wikipedia]: https://en.wikipedia.org/wiki/Pig_Latin
