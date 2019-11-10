# Code Performance :robot: and Optimization :stopwatch:

In the early days of cryptography :pager:, analysing the frequency of letters could be used to break encryption. This [java project](https://github.com/CPHBusinessSoftUFO/letterfrequencies) reads a file :page_with_curl: and prints out the frequency :bar_chart: of each of the letters in that file.  
This repository contains code implementation which achieves **51%** faster performance :chart_with_downwards_trend:.

</br>

---
## Current performance of the program :turtle:
We believe that the following performance measurements are free of errors due to the fact that we have **terminated all** the unnecessary background software and run the profiler **10 times** to accomplish consistent results (_in the IDE and also confirmed by running the program the day after the measurements were recorded_). Furthermore, we didn't include the time of `print_tally()` in our analysis, since this method serves only the presentation purposes.

We have plotted our results into a [box-plot](https://goodcalculators.com/box-plot-maker/), which provided us with a good overview of the measurements correlation.
<p align="center">
<img src="https://user-images.githubusercontent.com/21998037/68543365-5dbfbf00-03b6-11ea-8fd0-7ae424eb8ca6.png" width="60%">
</p>

:point_down: Where the **minimum**, **maximum**, **average** and **median** values can be found in the following table:

Min | Max | Mean | Median |
----|:----:|:----:|:----:|
236|376|287|276.5|

</br>

---
## Bottlenecks in the program <img src="https://user-images.githubusercontent.com/21998037/68543630-f146bf00-03b9-11ea-9ec1-2e1acc756eb6.jpg" height="40" align="center"> 
One of the main bottlenecks spotted while analyzing the performance results was the file reading. Additionally, we’ve noticed that we would try to use `put()` to verify if there was an exception caused, which would indicate that a _Hashmap_ key didn’t exist. 

</br>

---
## Improvement hypothesis :crystal_ball:
A possibility for dealing with the constant file input would be to simply read the entire file content at once - keeping the data in memory would enable us to perform operations faster. Next step can be to eliminate the little delay the `try`, `catch` blocks might cause by transforming them into an `if-else` statement, using the benefits of the faster `contains` operation as a condition.    

</br>

---
## Improved performance :rabbit2:
The following box-plot demonstrates the results achieved after profiling the code optimization following our hypothesis. The same tactics of closing the background programs and executing 10 times apply here for the reason of consistency measurements. With this implementation, we achieved an improvement of **51%** over the original implementation.

<p align="center">
<img src="https://user-images.githubusercontent.com/21998037/68543365-5dbfbf00-03b6-11ea-8fd0-7ae424eb8ca6.png" width="60%">
</p>

:mag_right: The new **minimum**, **maximum**, **average** and **median** values can be observed as follows:

Min | Max | Mean | Median |
----|:----:|:----:|:----:|
114|218|142.3|132|

</br>
</br>

An overall comparison is demonstrated by the next box-plot diagrams, where **Group 1** is the old program results and **Group 2** shows the improved version.

<p align="center">
<img src="https://user-images.githubusercontent.com/21998037/68544235-7aadbf80-03c1-11ea-9c08-967078af0556.png" width="60%">
</p>

</br>

___
> #### Assignment made by:   
`David Alves 👨🏻‍💻 ` :octocat: [Github](https://github.com/davi7725) <br />
`Elitsa Marinovska 👩🏻‍💻 ` :octocat: [Github](https://github.com/elit0451) <br />
> Attending "Investigation & reporting (UFO)" course of Software Development bachelor's degree
