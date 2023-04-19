# Polynomial-Calculator

## About
Design and implement a polynomial calculator using Java with a dedicated graphical interface through which the user can insert polynomials, select the mathematical operation (addition, subtraction, multiplication, derivative, integration) to be performed and view the result.

![image](https://user-images.githubusercontent.com/117029446/233016294-fb49a587-929a-45e3-8085-bc603f12b532.png)


## Graphical User Interface
For the user interface I used Java Swing.

• javax.swing - Is the most important package from Swing


## How to convert input string to polynomial
I used the regex package to split the string into monomials (split the string after - or +).

 java.util.regex package
 
• Contains classes used for pattern matching with regular expressions

• Regular expression = sequence of characters defining a search pattern

• Consists of the classes:
![image](https://user-images.githubusercontent.com/117029446/233021210-f6758d4f-6611-4010-879c-5bbb336b0714.png)


## Testing
JUnit using assertion.

Assertions are static methods defined in the org.junit.jupiter.api.Assertions class:
assertEquals, assertAll, assertNotEquals, assertTrue. 

I used assertEquals to check if the resulting polynomial is equal to the expected (correct) result.

