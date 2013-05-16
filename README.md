[![Build Status](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/badge/icon)](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/)


[Documentation](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/lastSuccessfulBuild/artifact/target/concordion/romannumerals/RomanNumeralsDescription.html)
[![Documentation](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/lastSuccessfulBuild/artifact/target/concordion/romannumerals/RomanNumeralsDescription.html)]

----------------------------
Triangulation and Baby Steps
----------------------------

This kata provides an excellent example of an implementation to follow baby steps.  For the novice, the desire is to decide initially what data structure could be used for the mapping, rather than adding the first test case based on the simplest possible solution and then allowing the design to emerge.

Initially, the implementation can consist of a series of if/else statements but as tests are added the following rule should be followed - 

"As the tests get more specific, the code gets more generic."

At this point, the implementation can be reworked, using triangulation to determine the more generic solution.  Uncle bob gives a nice explanation of the concept of this [here][1] -

[1]: http://cleancoder.posterous.com/the-transformation-priority-premise






