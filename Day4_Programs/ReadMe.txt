Java Exception Handling

Throwable (Base Class)


Error  -- (JVM/ System Level issues) errors which we cannot handle  ( OutOfMemoryError ), errors cannot be predicted , Usually we cannot 
catch in code , serious issues that may occur suddenly  for(i=0 ; i<n;i++)
An error is a serious issue that arises in the JVM or system environment , 
ususally outside the application control . It is also a throwable object , but it 
indicates problems that are not meant to be caught or handled in normal code by the programmers or Developers

eg: JVM runs out of memory 
Infinite recursion or a loop which causes a stack overflow

These are not recoverable .

Exception  --- Application Level issues -- which is an event that disrupts the normal flow of the program during execution. It is 
an object that represents an error or unexpected situation that can be handled gracefully using 
try , catch and finally blocks  also includes throw and throws key word.

try:=  business logic  --  you think that may be the code is risky
catch := handle immediately the exception after occured in try block 
finally block will execute in both the cases 


Pre Defined Exceptions

Runtime Exceptions  ( Unchecked Exceptions ) 

ArithmeticExceptions :  DivideByZero

IllegalArgumentException : NumberFormatException / IllegalThreadStateException

ClassCastException : It may throw when an object is cast to a class it's not an instance of

IndexOutOfBoundExcept : for invalid retreiving the values from the array or string for a invalid index range

Null Pointer Exception : which is pointing to null reference;


Compile Time Exceptions (Checked Exception)

classNotFoundexception -- Class - -SQL  Class.forName()

filenotfoundexception -- File Handling

InterruptedException  -- Multithreading concept
instantiation exception  - instances 

nosuchmethod exception -- method which does not exist


Custom Exceptions:  
A custom exception is a user-defined class that extends Exception(Checked)  or RuntimeException ( Unchecked) to represent specific error
conditions in our business logic

For eG: 

for job application to apply there is a certain age limit --- AgeNotFoundException
for withdraw the amount in banks  --- InsufficientFundsException

We can use here throw and throws keyword 

throw-- which is used to actually throw an exception(predefined or userdefined exception classes) 
object , we can use or define it inside a method or a block

throws -- which is used to declares that a method can throw an exceptions  , we can use it with method signature  


