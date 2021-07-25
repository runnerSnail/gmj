package main

import (
	"fmt"
)

func missingNumber(nums []int) int {
	i, j := 0, len(nums)-1
	// 1 2
	for i <= j {
		mid := i + (j-i)/2
		if nums[mid] == mid {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}
	return i
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//func kthLargest(root *TreeNode, k int) int {
//
//}

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}
func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
func main() {
	nums := []int{0, 1, 3}
	fmt.Println(missingNumber(nums))
}
