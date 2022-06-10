# Sum of length
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array. Calculate the sum of lengths of contiguous subarrays having all distinct elements.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N=3
arr[] = { 1,2,3 }
<strong>Output:</strong> 10
<strong>Explanation</strong>: 
{1, 2, 3} is a subarray of length 3 with 
distinct elements. Total length of length
three = 3. {1, 2}, {2, 3} are 2 subarray 
of length 2 with distinct elements. Total 
length of lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1
with distinct element. Total lengths of 
length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N=1
arr[] = { 1 }
<strong>Output:</strong> 1
<strong>Explanation</strong>: 
{1} is the only subarray with distinct 
elements of length 1.  
</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>sumoflength</strong>() that takes <strong>array arr and integer N</strong>&nbsp;as input parameters and returns the&nbsp;sum of lengths of contiguous subarrays having all distinct elements.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N).<br>
<strong>Expected Auxiliary Space:</strong> O(N).</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>6</sup></span></p>
 <p></p>
            </div>