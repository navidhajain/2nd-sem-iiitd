##MINHEAP

a=[4, 2, 5, 6, 1]

def minheaptree(tree, i):
  left=2*i+1
  right=2*i+2
  small=i
  print('l: ', left)
  print('r: ', right)
  print('small: ', small)
  if left<=len(tree)-1 and tree[small]>tree[left]:
    small=left
  if right<=len(tree)-1 and tree[small]>tree[right]:
    small=right
  if small!=i:
    temp=tree[i]
    tree[i]=tree[small]
    tree[small]=temp
    print('tree now is ', tree)
    minheaptree(tree, small)
    
  return tree

b= minheaptree(a, 0)   
print(minheaptree(b, 0))