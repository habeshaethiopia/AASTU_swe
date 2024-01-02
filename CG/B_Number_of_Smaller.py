x,y = map(int, input().split())
arr1=list(map(int, input().split()))
arr2=list(map(int, input().split()))
first=0
ans=[]
for i in arr2:
    while first<len(arr1) and arr1[first]<i:
        first+=1
    ans.append(first)
print(*ans)
