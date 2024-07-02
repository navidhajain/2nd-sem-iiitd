a=[8, 7, 10, 3, 2, 4]
def mergesort(x):
  
  if len(x)>1:
    half=int(len(x)/2)  
    left=x[:half]
    # print('left: ', left)
    right=x[half:]
    # print('right: ', right)
    mergesort(left)
    mergesort(right)
    i=j=k=0  
    # print(left, '#', right)
    # print('x is now ', x)
    while i<len(left) and j<len(right):
      if left[i]<right[j]:
        x[k]=left[i]
        i=i+1
      else:
        x[k]=right[j]
        j=j+1
      k=k+1    
    while i<len(left):
      x[k]=left[i]
      i=i+1
      k=k+1
    while j<len(right):
      x[k]=right[j]
      j=j+1
      k=k+1
  return x
# print(a)
print(mergesort(a))  