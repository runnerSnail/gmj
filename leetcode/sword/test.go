package main

import "fmt"

func main() {
	ch := make(chan int)
	go func() {
		ch <- 1
		ch <- 2

		close(ch)
	}()

	for i := range ch {
		fmt.Println(i)
	}

	// 多个grountine同时接触一个变，行为不可预知 属于data race

	/*
		atomic 解决单一变量一些多读问题
		单个变量一写多读 atomic
		多读多写 mutex 问题
	*/

	// 实践 读写🔒 写操作 cas 对于多cpu 效率并不高

	// 并发删除操作

	// 找到节点A和B 不存在直接删除

	// 跳表 生纬度
}
