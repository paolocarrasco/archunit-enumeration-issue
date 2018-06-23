ArchUnit enumeration issue
--------------------------

(ArchUnit)[https://www.archunit.org) 0.8.2 is very consistent with
the Java Reflection API, so when checking dependency from package
to package and one of the packages have enums, it reports a violation.

The violation is related to the fact that the method `Enum::values()`
internally uses the `Array::clone()` in the default package. More details
of this is in the Github issue [#81](https://github.com/TNG/ArchUnit/issues/81).

A solution for this would be to add the default package (if it is not
a problem) or to write custom code that avoids those calls.
The code here has the default package solution. It can be commented so
the issue can be seen.
