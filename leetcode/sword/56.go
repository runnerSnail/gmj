package main

func singleNumbers(nums []int) []int {
	xor := 0
	for _, value := range nums {
		xor ^= value
	}
	mask := 1
	for (xor & mask) == 0 {
		mask <<= 1
	}
	a := 0
	b := 0
	for _, value := range nums {
		if (value & mask) == 0 {
			a ^= xor
		} else {
			b ^= xor
		}
	}
	return []int{a, b}
}

func main() {

}
