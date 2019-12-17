package main

type recodeStruct struct {
	Start int
	Value int
}

func largestRectangleArea(heights []int) int {
	maxArea := 0
	stackArray := make([]recodeStruct, len(heights))
	topPos := 0
	for i, v := range heights {
		flagPush := false
		start := i
		if topPos == 0 || v > stackArray[topPos-1].Value {
			flagPush = true
		} else {
			for topPos > 0 && v < stackArray[topPos-1].Value {
				tmpArea := stackArray[topPos-1].Value * (i - stackArray[topPos-1].Start)
				if maxArea < tmpArea {
					maxArea = tmpArea
				}
				start = stackArray[topPos-1].Start
				topPos--
			}
			if topPos == 0 || v > stackArray[topPos-1].Value {
				flagPush = true
			}
		}
		if flagPush {
			stackArray[topPos] = recodeStruct{
				Start: start,
				Value: v,
			}
			topPos++
		}
	}
	if topPos > 0 {
		tmpArea := stackArray[topPos-1].Value * (len(heights) - stackArray[topPos-1].Start)
		if maxArea < tmpArea {
			maxArea = tmpArea
		}
		topPos--
	}
	return maxArea
}
