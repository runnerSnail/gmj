package main

import "fmt"

func reversePairs(nums []int) int {
	lenN := len(nums)
	if lenN < 2 {
		return 0
	}
	copyData := make([]int, lenN)
	copy(copyData, nums)
	temp := make([]int, lenN)
	return reversePair(copyData, 0, lenN-1, temp)
}

func reversePair(nums []int, left int, right int, temp []int) int {
	if left == right {
		return 0
	}
	mid := left + (right-left)/2
	leftParis := reversePair(nums, left, mid, temp)
	rightParis := reversePair(nums, mid+1, right, temp)
	crossPairs := mergeCount(nums, left, mid, right, temp)
	return leftParis + rightParis + crossPairs
}

func mergeCount(nums []int, left int, mid int, right int, temp []int) int {
	for i := left; i <= right; i++ {
		temp[i] = nums[i]
	}
	i := left
	j := mid + 1
	count := 0
	for k := left; k <= right; k++ {
		if i == mid+1 {
			nums[k] = temp[j]
			j++
		} else if j == right+1 {
			nums[k] = temp[i]
			i++
		} else if temp[i] <= temp[j] {
			nums[k] = temp[i]
			i++
		} else {
			nums[k] = temp[j]
			j++
			count += (mid - i + 1)
		}
	}
	return count
}

func change(arr []int) {
	arr[2] = 8
}

func main() {
	arr := []int{7, 6, 5, 4}
	fmt.Println(reversePairs(arr))
}
