package main

import "fmt"

/**
* Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	node1 := headA
	node2 := headB
	for {
		if node1 != node2 {
			if node1.Next != nil {
				node1 = node1.Next
			} else {
				node1 = headB
			}
			if node2.Next != nil {
				node2 = node2.Next
			} else {
				node2 = headA
			}
		} else {
			break
		}
	}
	return node1
}

func main() {
	for {
		break
	}
	fmt.Println("你好")
}
