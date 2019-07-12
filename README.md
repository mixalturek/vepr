Vepř
====

*~ yet another [pig-latin][wikipedia] translation tool*


Motivation
----------

Java task to show coding skills, nothing more...


Task requirements
-----------------

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


[wikipedia]: https://en.wikipedia.org/wiki/Pig_Latin
