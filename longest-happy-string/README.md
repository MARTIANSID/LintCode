<h2>1405. Longest Happy String</h2><h3>Medium</h3><hr><div><p>A string is called <em>happy</em> if it does&nbsp;not have any of the strings <code>'aaa'</code>, <code>'bbb'</code>&nbsp;or <code>'ccc'</code>&nbsp;as a substring.</p>

<p>Given three integers <code>a</code>, <code>b</code> and <code>c</code>, return <strong>any</strong> string <code>s</code>,&nbsp;which satisfies following conditions:</p>

<ul>
	<li><code>s</code> is <em>happy&nbsp;</em>and longest possible.</li>
	<li><code>s</code> contains <strong>at most</strong> <code>a</code>&nbsp;occurrences of the letter&nbsp;<code>'a'</code>, <strong>at most</strong> <code>b</code>&nbsp;occurrences of the letter <code>'b'</code> and <strong>at most</strong> <code>c</code> occurrences of the letter <code>'c'</code>.</li>
	<li><code>s&nbsp;</code>will only contain <code>'a'</code>, <code>'b'</code> and <code>'c'</code>&nbsp;letters.</li>
</ul>

<p>If there is no such string <code>s</code>&nbsp;return the empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> a = 1, b = 1, c = 7
<strong>Output:</strong> "ccaccbcc"
<strong>Explanation:</strong> "ccbccacc" would also be a correct answer.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> a = 2, b = 2, c = 1
<strong>Output:</strong> "aabbc"
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> a = 7, b = 1, c = 0
<strong>Output:</strong> "aabaa"
<strong>Explanation:</strong> It's the only correct answer in this case.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= a, b, c &lt;= 100</code></li>
	<li><code>a + b + c &gt; 0</code></li>
</ul>
</div>