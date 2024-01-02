drawLine(ctx, 0, 170, 0, 230, red)
while l<x and r<y:
    if arr1[l]<arr2[r]:
        ans.append(arr1[l])
        l+=1
    else:
        ans.append(arr2[r])
        r+=1
   
ans.extend(arr2[r:])
ans.extend(arr1[l:])
print(*ans)