import sys
sys.setrecursionlimit(10**6)

def partition(arr, l, r):
    pivot = arr[r]
    i = l
    for j in range(l, r):
        if arr[j] <= pivot:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[r] = arr[r], arr[i]
    return i

def quickSelect(arr, l, r, k):
    if 0 < k <= r - l + 1:
        index = partition(arr, l, r)

        if index - l == k - 1:
            return arr[index]
        elif index - l > k - 1:
            return quickSelect(arr, l, index - 1, k)
        else:
            return quickSelect(arr, index + 1, r, k - index + l - 1)
    return -1  # 에러 처리

N, M = map(int, input().split())
scores = list(map(int, input().split()))

k = N - M + 1
print(quickSelect(scores, 0, N - 1, k))
