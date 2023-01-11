class Solution(object):
    def minTime(self, n, edges, hasApple):
        """
        :type n: int
        :type edges: List[List[int]]
        :type hasApple: List[bool]
        :rtype: int
        """
        graph=[]
        for i in range(0,n):
          graph.append([])
        for edge in edges:
          u,v=edge[0],edge[1]
          graph[u].append(v)
          graph[v].append(u)
        return dfs(graph,hasApple,0,-1)

def dfs(graph,hasApple,src,par):
  time=0
  for child in graph[src]:
    if child!=par:
      time+=dfs(graph,hasApple,child,src)
  if src == 0:
    return time
  if time > 0 or hasApple[src]:
    return time+2
  return time