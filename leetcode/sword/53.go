package main

import "fmt"

func search(nums []int, target int) int {
	i, j := 0, len(nums)-1
	for i <= j {
		mid := i + (j-i)/2
		if nums[mid] <= target {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}
	fmt.Println(i, j)
	right := i
	if j >= 0 && nums[j] != target {
		return 0
	}
	//i = 0
	for i <= j {
		mid := i + (j-i)/2
		if nums[mid] < target {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}
	left := j
	return right - left - 1
}

func main() {
	// 5 7 7 8 8 10
	// 0 1 2 3 4 5
	nums := []int{5, 7, 7, 8, 8, 10}
	search(nums, 8)
}
