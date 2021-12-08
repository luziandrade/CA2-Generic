#Analysis
___

When it comes to assessing performance, there are differences between programming languages, and it necessitates a better understanding from both a software and hardware standpoint.

In order to bring the code into a steady-state, iterations should be short and performed in cycles at the start of each test and every Architect should keep performance in mind when building and implementing Quality Attribute methods by :

1. Avoiding writing long methods, because the method is loaded in stack memory at class loading and during method call, it is better for maintenance and performance.

2. Avoiding using multiple If-else statements, If we use too many conditional if-else lines, efficiency will suffer since JVM will have to compare the conditions. When compared to if-else, the switch statement provides a performance advantage.

3. Avoiding using getting the size of the collection in the Loop, instead, get the size of the collection before iterating over any collection and never get it during iteration.

The rotate(List?>, int) method rotates the elements in the supplied list by the specified amount of rotation.It includes polymorphic collection algorithms, "wrappers," which return a new collection backed by a specified collection, and other miscellaneous items.
