[![Build Status](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/badge/icon)](https://peterrhysthomas.ci.cloudbees.com/job/Roman%20Numerals/)

-------------------------------------------
Roman Numeral Kata
-------------------------------------------

| Symbol | Value |
|      I |     1 |
|      V |     5 | 
|      X |    10 |
|      L |    50 |
|      C |   100 |
|      D |   500 |
|      M |  1000 |

Additive and Subtractive Principles - 

Generally, Roman numerals are written in descending order from left to right, and are added sequentially, for example MMVI (2006) is interpreted as 1000 + 1000 + 5 + 1.
Certain combinations employ a subtractive principle, which specifies that where a symbol of smaller value precedes a symbol of larger value, the smaller value is subtracted from the larger value, and the result is added to the total. For example, in MCMXLIV (1944), the symbols C, X and I each precede a symbol of higher value, and the result is interpreted as 1000 plus (1000 minus 100) plus (50 minus 10) plus (5 minus 1).

| Symbol  | Value |
|     IV  |     4 |
|     VI  |     6 |
|   MMVI  |  2006 |
| MCMXCIV |  1994 |

Advanced Rules - 
(Despite there being no standardisation for Roman Numerals, the following rules generally apply)

- The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. "D", "L", and "V" can never be repeated.  This due to the additive (or subtractive) total of these consecutive digits being less than the next symbol's value.

| Symbol | Value | Valid?  |
|    III |     3 |   Valid |
|   IIII |     4 | Invalid |
|     IV |     4 |   Valid |
|  XXXIX |    39 |   Valid |
|     DD |  1000 | Invalid |

- "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted. 

| Symbol | Value | Valid?  |
|     IL |    49 | Invalid |
|   XLIX |    49 |   Valid |

----------------------------
Triangulation and Baby Steps
----------------------------

This kata provides an excellent example of an implementation to follow baby steps.  For the novice, the desire is to decide initially what data structure could be used for the mapping, rather than adding the first test case based on the simplest possible solution and then allowing the design to emerge.

Initially, the implementation can consist of a series of if/else statements but as tests are added the following rule should be followed - 

"As the tests get more specific, the code gets more generic."

At this point, the implementation can be reworked, using triangulation to determine the more generic solution.  Uncle bob gives a nice explanation of the concept of this here - 

http://cleancoder.posterous.com/the-transformation-priority-premise






