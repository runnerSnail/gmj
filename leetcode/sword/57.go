package main

func singleNumber(nums []int) int {
	var counts [32]int
	for i := 0; i < len(nums); i++ {
		for j := 0; j < 32; j++ {
			counts[j] += nums[i] & 1
			nums[i] >>= 1
		}
	}

	for i := 0; i < len(counts); i++ {
		counts[i] %= 3
	}
	res := 0
	for i := 0; i < len(counts); i++ {
		res <<= 1
		res |= counts[31-i]
	}
	return res
}
func twoSum(nums []int, target int) []int {
	left := 0
	right := len(nums) - 1
	for left < right {
		current := nums[left] + nums[right]
		if current < target {
			left++
		} else if current > target {
			right--
		} else {
			return []int{nums[left], nums[right]}
		}
	}

	return []int{}
}
func main() {
	arr := []int{3, 3, 4, 3}
	singleNumber(arr)
}
