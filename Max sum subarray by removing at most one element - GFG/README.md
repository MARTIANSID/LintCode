# Max sum subarray by removing at most one element
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are given array <strong>A </strong>of size<strong> n</strong>. You need to find the maximum-sum sub-array with the condition that you are allowed to skip at most one element.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>n = 5
A[] = {1,2,3,-4,5}
<strong>Output: </strong>11<strong>
Explanation: </strong>We can get maximum sum
subarray by skipping -4.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>n = 8
A[] = {-2,-3,4,-1,-2,1,5,-3}
<strong>Output: </strong>9<strong>
Explanation: </strong>We can get maximum sum
subarray by skipping -2 as [4,-1,1,5]
sums to 9, which is the maximum
achievable sum.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong></span></p>

<p><span style="font-size:18px">Your task is to complete the function <strong>maxSumSubarray</strong> that take array and size as parameters and returns the maximum sum.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(N).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= 100<br>
-10<sup>3</sup> &lt;= A<sub>i</sub>&lt;= 10<sup>3</sup></span></p>
 <p></p>
            </div>