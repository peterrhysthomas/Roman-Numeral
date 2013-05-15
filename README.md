[![Build Status](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/badge/icon)](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/)


[Documentation](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/lastSuccessfulBuild/artifact/target/concordion/romannumerals/RomanNumeralsDescription.html)


Advanced Rules - 
(Despite there being no standardisation for Roman Numerals, the following rules generally apply)

The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. "D", "L", and "V" can never be repeated.  This due to the additive (or subtractive) total of these consecutive digits being less than the next symbol's value.

<table>
  <tr>
    <th>Symbol</th><th>Value</th><th>Valid?</th>
  </tr>
  <tr>
    <th>III</th><th>3</th><th>Valid</th>
  </tr>
  <tr>
    <th>IIII</th><th>4</th><th>Invalid</th>
  </tr>
  <tr>
    <th>IV</th><th>4</th><th>Valid</th>
  </tr>
  <tr>
    <th>XXXIX</th><th>39</th><th>Valid</th>
  </tr>
  <tr>
    <th>DD</th><th>1000</th><th>Invalid</th>
  </tr>
</table>

"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.

<table>
  <tr>
    <th>Symbol</th><th>Value</th><th>Valid?</th>
  </tr>
  <tr>
    <th>IL</th><th>49</th><th>Invalid</th>
  </tr>
  <tr>
    <th>XLIX</th><th>49</th><th>Valid</th>
  </tr>
</table>

----------------------------
Triangulation and Baby Steps
----------------------------

This kata provides an excellent example of an implementation to follow baby steps.  For the novice, the desire is to decide initially what data structure could be used for the mapping, rather than adding the first test case based on the simplest possible solution and then allowing the design to emerge.

Initially, the implementation can consist of a series of if/else statements but as tests are added the following rule should be followed - 

"As the tests get more specific, the code gets more generic."

At this point, the implementation can be reworked, using triangulation to determine the more generic solution.  Uncle bob gives a nice explanation of the concept of this [here][1] -

[1]: http://cleancoder.posterous.com/the-transformation-priority-premise






