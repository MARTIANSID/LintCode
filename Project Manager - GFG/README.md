# Project Manager
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">An IT company is working on a large project. The project is broken into <strong>N</strong> modules and distributed to different teams. Each team can work parallelly. The amount of time (in months) required to complete each module is given in an array <strong>duration[ ]</strong>&nbsp;<em>i.e.</em> time needed to complete<strong> i<sup>th</sup>&nbsp;</strong>module is <strong>duration[i]</strong> months.&nbsp;<br>
You are also given&nbsp;<strong>M</strong> <strong>dependencies</strong>&nbsp;such that for each i (1 ≤ i ≤ M)&nbsp;&nbsp;<strong>dependencies[i][1]<sup>th</sup> </strong>module can be started after&nbsp;<strong>dependencies[i][0]<sup>th</sup> </strong>module is completed.<br>
As the project manager, compute the minimum time required to complete the project.<br>
<strong>Note</strong>: It is guaranteed that a module is not dependent on itself.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
N = 6, M = 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies[][]:
[[5, 2]
 [5, 0]
 [4, 0]&nbsp;
 [4, 1]
 [2, 3]
 [3, 1]]
<strong>Output:</strong> 
8
<strong>Explanation: </strong>
</span><img alt="graph" src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/graph.png" style="height:200px; width:250px" class="img-responsive">
<span style="font-size:18px">The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
N = 3, M = 3
duration[] = {5, 5, 5}
dependencies[][]:
[[0, 1]
 [1, 2]
 [2, 0]]
<strong>Output:</strong> 
-1
<strong>Explanation: </strong>
There is a cycle in the dependency graph 
hence the project cannot be completed.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Complete the function <strong>minTime()</strong> which takes <strong>N</strong>, <strong>M</strong>, <strong>duration</strong> <strong>array</strong>, and <strong>dependencies</strong> <strong>array</strong> as input parameter and return the minimum time required. return -1 if the project can not be completed.&nbsp;</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N+M)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤&nbsp;N ≤&nbsp;10<sup>5</sup><br>
0 ≤&nbsp;M ≤&nbsp;2*10<sup>5</sup><br>
1 ≤&nbsp;duration[i] ≤&nbsp;10<sup>5</sup><br>
0 ≤&nbsp;dependencies[i][j]&nbsp;&lt;&nbsp;N</span></p>
 <p></p>
            </div>