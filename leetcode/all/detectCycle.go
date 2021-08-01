package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	sceen := map[*ListNode]struct{}{}
	for head != nil {
		if _, ok := sceen[head]; ok {
			return head
		}
		sceen[head] = struct{}{}
		head = head.Next
	}
	return nil

}

func main() {
	nodes := make([]*ListNode, 10)
	for node := 1; node <= 10; node++ {
		// nodes = append(nodes, &ListNode{})
		nodes[node-1] = &ListNode{
			Val: 10,
		}
	}
	// nodes = append(nodes, &ListNode{})
	fmt.Println(nodes[0].Val)
}
