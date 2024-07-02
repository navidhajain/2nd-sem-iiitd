allpath={}
def findpath(tree, parent, path=[]):
  if parent not in path:
    path.append(parent)
    for child in tree[parent]:
      def findpath(tree, child, path) 
  length=len(path)
  allpath[length]=path  
maxlen=0
for l in allpath:
  if l>maxlenth:
    maxlenth=l
longpath=allpath[l]
print(longpath)
