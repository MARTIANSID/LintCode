# Find the number of subarrays having even sum
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array <strong>Arr[]</strong>&nbsp;of size <strong>N.</strong>&nbsp;Find the number of subarrays whose sum is an even number.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N = 6
Arr[] = {1, 2, 2, 3, 4, 1}
<strong>Output:</strong> 9
<strong>Explanation:</strong> The&nbsp;array {1, 2, 2, 3, 4, 1} 
has 9 such possible subarrays. These are-
&nbsp;{1, 2, 2, 3} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Sum = 8
&nbsp;{1, 2, 2, 3, 4} &nbsp; &nbsp;&nbsp;&nbsp; Sum = 12
&nbsp;{2} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Sum = 2 (At index 1)
&nbsp;{2, 2} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Sum = 4
&nbsp;{2, 2, 3, 4, 1} &nbsp; &nbsp;&nbsp;  Sum&nbsp;= 12
&nbsp;{2} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Sum = 2 (At index 2)
&nbsp;{2, 3, 4, 1} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Sum&nbsp;= 10
&nbsp;{3, 4, 1} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;Sum&nbsp;= 8
&nbsp;{4} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Sum = 4
</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N = 4
Arr[] = {1, 3, 1, 1}
<strong>Output:</strong> 4
<strong>Explanation:</strong>&nbsp;The&nbsp;array {1, 3, 1, 1} 
has 4 such possible subarrays.
These are-
&nbsp;{1, 3} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  Sum = 4
&nbsp;{1, 3, 1, 1} &nbsp; &nbsp;&nbsp;&nbsp;Sum = 6
&nbsp;{3, 1} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Sum = 4
&nbsp;{1, 1} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Sum = 2
</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>countEvenSum()</strong>&nbsp;which takes the array of integers&nbsp;<strong>arr[]</strong>&nbsp;and its size&nbsp;<strong>n&nbsp;</strong>as input&nbsp;parameters and returns an integer denoting the answer.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;=&nbsp;N&nbsp;&lt;= 10<sup>5</sup><br>
1&lt;= Arr[i] &lt;=10<sup>9</sup></span></p>

<p>&nbsp;</p>
 <p></p>
            </div>