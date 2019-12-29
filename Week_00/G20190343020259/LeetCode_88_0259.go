package G20190343020259

func merge(nums1 []int, m int, nums2 []int, n int)  {
	p1 := m - 1
	p2 := n - 1
	p := m + n - 1

	for p1 >= 0 && p2 >= 0 {
		if nums1[p1] < nums2[p2] {
			nums1[p] = nums2[p2]
			p2--
		} else {
			nums1[p] = nums1[p1]
			p1--
		}
		p--
	}

	if p2 >= 0 {
		for i := 0; i <= p2; i++ {
			nums1[i] = nums2[i]
		}
	}
}
