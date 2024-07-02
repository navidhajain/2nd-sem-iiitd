class Node:
  def __init__(self, name):
    self.name=name
    self.edges=[]

class Graph(Node):
  def __init__(self, nodes=[]):
    self.nodes=nodes
    self.edges1=[]

  def addNode(self, name):
    newnode=Node(name)
    self.nodes.append(newnode)

  def addEdge(self, node1, node2):
    node1.edges.append(node2)
    node2.edges.append(node1)
    self.edges1.append((node1, node2))    

  def dijkstra(self, start, end, path=[]):
    if start not in path:
      path.append(start)

#######################################


graph={
	0:[1, 2, 3, 4],
	1:[3],
	2:[4],
	3:[4]
	}

def dijkstra(graph, start, end, path=[], j=float('inf')):
  global i
  i=0
  # print('start:')
  print(start)
  if start not in path:
    path.append(start)
    print('path is: ', path) 
    for kid in graph[start]:
      if kid==end:
        # print('kid ', kid)
        path.append(end)
        print('len: ', i)
        i=i+1
        print(start , ' length: ', i)
        if i<j:
          j=i
          print('j is: ', j)
          shortp=path
          print('shortp is ', shortp)
        i=0
        print('restarting: ', i) 
        while len(path)!=1:
          path.pop()  
        print('when path ends:', path)    
      else:
        i=i+1
        print("kid ", kid, ", ", i)
        dijkstra(graph, kid, end, path, j)