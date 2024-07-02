class Node:
  list1=[]
  list2=[]
  list3=[]
  def __init__(self, name, children, parent):
    self.name=name
    self.children=children
    self.parent=parent
    if parent not in list1:
      list1.append(parent)
    if name not in list2: 
      list2.append(name)
    if children not in list3:  
      list3.append(children)

  def getchildren(self):
    return self.children

  def getparent(self):
    return self.parent

  def getName(self):
    return self.name

class Tree(Node):
  def __init__(self, root):
    self.root=root
    self.name=super().getname()
    self.children=super().getchildren()
    self.parent=super().getparent()

  def dfs(self, big=self.root, path=[]):
    if big not in path: 
      path.append(self.root)
      kid1=big.super().getchildren()
      for kid1s in kid1:
        if kid1s in list3:
          spath=dfs(kid1s, path)
    return path

  def bfs(self, path=[]):
    path.append(self.root)
    bfslist.append(self.root)
    while bfslist!=0:
      fword=bfslist.pop(0)
      bfskid=fword.super().getchildren()
      for bfskid1 in bfskid:
        if bfskid1 not in path:
          path.append(bfskid1)
          bfslist.append(bfskid1)
    return path


    